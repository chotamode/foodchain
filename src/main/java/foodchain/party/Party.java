package foodchain.party;

import foodchain.channels.Channel;
import foodchain.channels.ProductChannel;
import foodchain.channels.util.Payment;
import foodchain.channels.util.RP;
import foodchain.channels.util.Request;
import foodchain.product.Product;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Party.
 */
public abstract class Party implements ChannelObserver {
    protected int balance;
    protected final String name;
    protected final PartyType partyType;
    protected List<Product> products;
    protected List<Request> requests;
    protected List<Channel> channels;
    protected List<Payment> payments;

    public void sendRequest(Request request, ProductChannel channel){
        if(channels.contains(channel)){
            channel.addRequest(request);
        }else{
            System.out.println("You don't subscribed to this channel");
        }
    }

    @Override
    public void attach(Channel channel) {
        channels.add(channel);
    }

    @Override
    public void detach(Channel channel) {
        channels.remove(channel);
    }

    @Override
    public void update(RP rp) {
        if(rp instanceof Request){
            requests.add((Request) rp);
        }else{
            payments.add((Payment)rp);
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
        this.channels = new LinkedList<Channel>();
    }

    public abstract void sendProduct(Product product);

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
