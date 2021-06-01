package foodchain.party;

import foodchain.Reporter;
import foodchain.channels.Channel;
import foodchain.channels.MoneyChannel;
import foodchain.channels.ProductChannel;
import foodchain.channels.util.Payment;
import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.product.Products.ProductType;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.*;

/**
 * The type Party.
 */
public abstract class Party implements ChannelObserver {
    protected static MoneyChannel moneyChannel;
    protected static ProductChannel productChannel;
    protected final String name;
    private final int margin;
    public Queue<Request> requests;
    protected float balance;
    public List<Product> products;
    protected Map<Transaction, Boolean> blocks; //payments transactions, boolean means if money accepted
    protected Transaction lastTransactionMoney = null;
    protected Transaction lastTransactionProduct = null;
    protected Product currentProduct;
    Reporter reporter = Reporter.getReporter();

    /**
     * Instantiates a new Party.
     *
     * @param name    the name
     * @param balance the balance
     * @param margin  the margin
     */
    protected Party(String name, int balance, int margin) {
        if (margin > 100) {
            margin = margin % 100;
        }
        this.name = name;
        this.balance = balance;
        this.margin = margin;
        this.products = new LinkedList<>();
        this.requests = new LinkedList<>();
        this.blocks = new HashMap<>();
    }

    /**
     * For Disributor.
     *
     * He knows where to deliver so he can,
     * add Process Transaction or Storage Transaction
     * Add type of transaction.
     *
     * @param creator the creator
     */
    public void addTypeofTransaction(Party creator) {
        if (this instanceof Processor) {
            productChannel.addProcessTransaction(creator, creator.currentProduct);
        } else if (this instanceof Storage) {
            productChannel.addStoreTransaction(creator, creator.currentProduct);
        }
    }

    /**
     * Request paid boolean.
     * Checks if request was paid or no;
     *
     * @param request the request
     * @return the boolean
     */
    protected boolean requestPaid(Request request) {
        for (Map.Entry<Transaction, Boolean> entry : blocks.entrySet()
        ) {
            if (entry.getKey().getTransactionType() == TransactionType.MONEY
                    && request.getRespondingParty() == ((MoneyTransaction) entry.getKey()).getReciever()
                    && request.getRespondingParty() == this
                    && request.getCost() == ((MoneyTransaction) entry.getKey()).getMoney()
                    && !entry.getValue()) {
                entry.setValue(true);
                return false;
            }
        }
        return true;
    }

    /**
     * Fulfills request.
     * Use to process request
     *
     * @param request the request
     */
    public void fulfillRequest(Request request) {
        if (request.getPartyType() != this.getPartyType()) {
            System.out.println("You can't fulfill this request(wrong party type)");
            return;
        }
        processRequest(request);
    }

    /**
     * For Distributor.
     * He uses it to get product.
     * Give product.
     *
     * @param receiver    the receiver
     * @param productType the product type
     */
    protected void giveProduct(Party receiver, ProductType productType) {
        for (Product p : products
        ) {
            if (p.getProductType().getProductTypes() == productType.getProductTypes()
                    && productType.getQuantity() <= p.getProductType().getQuantity()) {
                receiver.receiveProduct(p.split(productType.getQuantity()));
                this.clearTheCounters();
            }
        }
    }

    /**
     * Clear the counters.
     * Method to clear List of products
     * if there some products with amount = 0.
     */
    protected void clearTheCounters() {
        this.products.removeIf(p -> p.getProductType().getQuantity() == 0);
    }

    /**
     * For Distributor.
     * Helps distributor to give product to receiver
     * USE: receiver.receiveProduct
     * Receive product.
     *
     * @param product the product
     */
    protected void receiveProduct(Product product) {
        if (this.products.contains(product)) {
            this.products.get(this.products.indexOf(product)).getProductType().addToCounters(product.getProductType().getQuantity());
        } else {
            this.products.add(product);
        }
    }

    /**
     * Gets party type.
     *
     * @return the party type
     */
    public abstract PartyType getPartyType();

    /**
     * Process request.
     * Checks if it can process request and
     * if not it asks next(makes request)
     *
     * @param request the request
     */
    protected abstract void processRequest(Request request);

    /**
     * Can process request boolean.
     * Checks if this Party can process request
     *
     * @param request the request
     * @return the boolean
     */
    protected boolean canProcessRequest(Request request) {
        return request.getPartyType() == this.getPartyType();
    }

    /**
     * Product available boolean.
     * if it is available it returns true
     * and sets this current product from list of products
     *
     * @param request the request
     * @return the boolean
     */
    protected boolean productAvailable(Request request) {
        for (Product p : products
        ) {
            if (p.getProductType().getProductTypes() == request.getProductType().getProductTypes()
                    && request.getAmount() <= p.getProductType().getQuantity()) {
                this.currentProduct = p;
                return true;
            }
        }
        return false;
    }

    @Override
    public void attach(Channel channel) {
        if (channel instanceof MoneyChannel) {
            moneyChannel = (MoneyChannel) channel;
        } else {
            productChannel = (ProductChannel) channel;
        }
    }

    @Override
    public void detach(Channel channel) {
        if (channel instanceof MoneyChannel && channel == moneyChannel) {
            moneyChannel = null;
        } else if (channel instanceof ProductChannel && channel == productChannel) {
            productChannel = null;
        }
    }

    @Override
    public void update(Request request) {
        if (canProcessRequest(request)) {
            requests.add(request);
        }
    }

    @Override
    public void update(Transaction transaction) {
        if (transaction.getTransactionType() == TransactionType.MONEY) {
            if (((MoneyTransaction) transaction).getReciever() == this) {
                balance = balance + ((MoneyTransaction) transaction).getMoney();
                System.out.println(this.name + " has received money!");
            } else if (transaction.getCreator() == this) {
                balance = balance - ((MoneyTransaction) transaction).getMoney();
                System.out.println(this.name + " has paid!");
            }
            lastTransactionMoney = transaction;
            blocks.putIfAbsent(lastTransactionMoney, false);
        } else if (transaction.getTransactionType() != TransactionType.MONEY) {
            lastTransactionProduct = transaction;
            blocks.putIfAbsent(lastTransactionProduct, true);
        }
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    protected void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets last transaction money.
     *
     * @return the last transaction money
     */
    public Transaction getLastTransactionMoney() {
        return lastTransactionMoney;
    }

    /**
     * Gets last transaction product.
     *
     * @return the last transaction product
     */
    protected Transaction getLastTransactionProduct() {
        return lastTransactionProduct;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    protected List<Product> getProducts() {
        return products;
    }

    /**
     * Request payment.
     * Makes new Payment and then uses update()
     * to update purses of parties
     *
     * @param request the request
     */
    public void requestPayment(Request request) {
        System.out.println("Requesting payment");
        if (moneyChannel == null) {
            moneyChannel = new MoneyChannel(TransactionType.MONEY);
        }
        moneyChannel.attach(request.getRespondingParty());
        moneyChannel.attach(request.getCreator());

        Payment payment = new Payment(this,
                request.getRespondingParty(),
                request.getCost());
        reporter.addPartiesReport(request.getRespondingParty().getClass().getSimpleName() + ": " + request.getRespondingParty().getName() + " asking ~ "
                + (int) (request.getCost() - request.getProductType().getCost()) + " for his work");
        moneyChannel.addPaymentTransaction(payment);
        request.setPaid();
    }

    /**
     * Gets margin.
     *
     * @return the margin
     */
    public int getMargin() {
        return margin;
    }

    /**
     * Gets money channel.
     *
     * @return the money channel
     */
    protected MoneyChannel getMoneyChannel() {
        return moneyChannel;
    }

    /**
     * Gets blocks.
     *
     * @return the blocks
     */
    protected Map<Transaction, Boolean> getBlocks() {
        return blocks;
    }
}
