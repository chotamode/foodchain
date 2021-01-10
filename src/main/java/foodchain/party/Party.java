package foodchain.party;

import foodchain.channels.Channel;
import foodchain.channels.MoneyChannel;
import foodchain.channels.ProductChannel;
import foodchain.channels.util.DeliveryRequest;
import foodchain.channels.util.Payment;
import foodchain.channels.util.Request;
import foodchain.party.farmer.Farmer;
import foodchain.product.Product;
import foodchain.product.Products.ProductType;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.*;

public abstract class Party implements ChannelObserver {
    protected float balance;
    protected final String name;
    protected List<Product> products;
    protected Queue<Request> requests;
    protected static MoneyChannel moneyChannel;
    protected static ProductChannel productChannel;
    protected Map<Transaction, Boolean> blocks; //payments transactions, boolean means if money accepted
    protected Transaction lastTransactionMoney = null;
    protected Transaction lastTransactionProduct = null;
    private final int margin;
    protected Product currentProduct;

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

    public void addTypeofTransaction(Party creator){
        if(this instanceof Processor){
            productChannel.addProcessTransaction(creator, creator.currentProduct);
        }else if(this instanceof Storage){
            productChannel.addStoreTransaction(creator, creator.currentProduct);
        }
    }

    protected boolean requestPaid(Request request) {
        for (Map.Entry<Transaction, Boolean> entry : blocks.entrySet()
        ) {
            if (entry.getKey().getTransactionType() == TransactionType.MONEY
                    && request.getRespondingParty() == ((MoneyTransaction) entry.getKey()).getReciever()
                    && request.getRespondingParty() == this
                    && request.getCost() == ((MoneyTransaction) entry.getKey()).getMoney()
                    && !entry.getValue()) {
                entry.setValue(true);
                return true;
            }
        }
        return false;
    }

    protected void fulfillRequest(Request request) {
        if (request.getPartyType() != this.getPartyType()) {
            System.out.println("You can't fulfill this request(wrong party type)");
            return;
        }
        processRequest(request);
    }

    protected void giveProduct(Party receiver, ProductType productType){
        for (Product p : products
        ) {
            if (p.getProductType().getProductTypes() == productType.getProductTypes()
                    && productType.getQuantity() <= p.getProductType().getQuantity()) {
                receiver.receiveProduct(p.split(productType.getQuantity()));
                this.clearTheCounters();
            }
        }
    }

    protected void clearTheCounters(){
        this.products.removeIf(p -> p.getProductType().getQuantity() == 0);
    }
    protected void receiveProduct(Product product) {
        if(this.products.contains(product)){
            this.products.get(this.products.indexOf(product)).getProductType().addToCounters(product.getProductType().getQuantity());
        }else{
            this.products.add(product);
        }
    }

    public abstract PartyType getPartyType();

    protected abstract void processRequest(Request request);

    protected boolean canProcessRequest(Request request) {
        return request.getPartyType() == this.getPartyType();
    }

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

    protected void sendRequest(ProductType productType) {
        if (this.balance < productType.getCost()) {
            System.out.println("You don't have enough money");
            return;
        }
        if (productChannel != null) {
            Request request = new Request(this, productType, this.getPartyType());
            productChannel.addRequest(request);
        } else {
            System.out.println("You don't subscribed to product channel");
        }
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

    public float getBalance() {
        return balance;
    }

    protected void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Transaction getLastTransactionMoney() {
        return lastTransactionMoney;
    }

    protected Transaction getLastTransactionProduct() {
        return lastTransactionProduct;
    }

    protected List<Product> getProducts() {
        return products;
    }

    public void requestPayment(Request request) {
//        if(request.getRespondingParty() != this){
//            System.out.println("You are not responsible for this request");
//            return;
//        }
        System.out.println("Requesting payment");
        if (moneyChannel == null) {
            moneyChannel = new MoneyChannel(TransactionType.MONEY);
        }
        moneyChannel.attach(request.getRespondingParty());
        moneyChannel.attach(request.getCreator());

        Payment payment = new Payment(this,
                request.getRespondingParty(),
                request.getCost());
        moneyChannel.addPaymentTransaction(payment);
        request.setPaid();
    }

    public int getMargin() {
        return margin;
    }

    protected MoneyChannel getMoneyChannel() {
        return moneyChannel;
    }

    protected Map<Transaction, Boolean> getBlocks() {
        return blocks;
    }
}
