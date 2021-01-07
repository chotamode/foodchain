package foodchain.party;

import foodchain.channels.Channel;
import foodchain.channels.MoneyChannel;
import foodchain.channels.ProductChannel;
import foodchain.channels.util.Payment;
import foodchain.channels.util.RP;
import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.transactions.GenesisTransaction;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.ProductTransaction;
import foodchain.transactions.Transaction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Party.
 */
public abstract class Party implements ChannelObserver {
    protected int balance;
    protected final String name;
    protected final PartyType partyType;
    protected List<Product> products;
    protected List<Request> requests;
    protected MoneyChannel moneyChannel;
    protected ProductChannel productChannel;
    protected Map<Transaction, Boolean> blocks;
    protected Transaction genesisTransaction = new GenesisTransaction(null, null, null);
    protected Transaction lastTransaction = genesisTransaction;

    /**
     * Create transaction based on this request.
     *
     * @param request
     */
    public void fulfillRequest(Request request) {
        if (request.getType() != this.partyType) {
            System.out.println("You can't fulfill this request(wrong party type)");
            return;
        } else if (!productAvailable(request)) {
            System.out.println("Not enough product");
            return;
        }
        processRequest(request);
        this.productChannel.addTransaction(this, request);

    }

    /**
     * Checks if party have enough product
     *
     * @param request
     * @return true if enough
     */
    public boolean productAvailable(Request request) {
        for (Product p : products
        ) {
            if (p.getProductType().getProduct() == request.getProduct().getProductType().getProduct()
                    && request.getAmount() <= p.getProductType().getQuantity()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Do stuff that this party do and change Request type.
     *
     * @param request
     */
    public abstract void processRequest(Request request);

    public void sendRequest(Request request, ProductChannel channel) {
        if (productChannel != null) {
            productChannel.addRequest(request);
        } else {
            System.out.println("You don't subscribed to product channel");
        }
    }

    public void sendMoney(Payment payment) {
        if (moneyChannel != null) {
            if (this.balance < payment.getMoney()) {
                System.out.println("Not enough money");
                return;
            }
            moneyChannel.addPayment(payment);
        } else {
            System.out.println("You don't subscribed to money channel");
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
        if (channel instanceof MoneyChannel && channel == this.moneyChannel) {
            moneyChannel = null;
        } else if (channel instanceof ProductChannel && channel == this.productChannel) {
            productChannel = null;
        }
    }


    /**
     * If got Request add it to requests list.
     * If got payment increase or decrease balance and
     * add new block into this party blockchain, and
     * updates lastTransaction
     * @param rp Request or Payment
     */
    @Override
    public void update(RP rp) {
        if (rp instanceof Request) {
            requests.add((Request) rp);
        } else if (rp instanceof Payment) {
            if (((Payment) rp).getReciever() == this) {
                balance = balance + ((Payment) rp).getMoney();
            } else if (((Payment) rp).getSender() == this) {
                balance = balance - ((Payment) rp).getMoney();
            }
            lastTransaction = new MoneyTransaction(
                    ((Payment) rp).getReciever(),
                    ((Payment) rp).getSender(),
                    ((Payment) rp).getMoney(),
                    lastTransaction);
            blocks.put(lastTransaction,
                    false
            );
        }
    }

    /**
     * Instantiates a new Party.
     *
     * @param name      the name
     * @param balance   the balance
     * @param partyType the party type
     */
    protected Party(String name, int balance, PartyType partyType) {
        this.name = name;
        this.balance = balance;
        this.partyType = partyType;
        this.products = new LinkedList<Product>();
        this.requests = new LinkedList<Request>();
        this.blocks = new HashMap<Transaction, Boolean>();
        this.blocks.put(genesisTransaction, null);
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(int balance) {
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
     * Gets party type.
     *
     * @return the party type
     */
    public PartyType getPartyType() {
        return partyType;
    }
}
