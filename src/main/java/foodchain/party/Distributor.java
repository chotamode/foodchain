package foodchain.party;

import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.transactions.Transaction;

/**
 * The type Distributor.
 */
public class Distributor extends Party{

    private static final PartyType partyType = PartyType.DISTRIBUTOR;

    /**
     * Instantiates a new Distributor.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Distributor(String name, int balance) {
        super(name, balance, margin);
    }

    public void sendProduct(Product product) {

    }

    @Override
    protected boolean requestPaid(Request request) {
        return true;
    }

    @Override
    public void fulfillRequest(Request request) {
        //:)
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.DISTRIBUTOR;
    }

    @Override
    public void processRequest(Request request) {

    }

    @Override
    public void update(Transaction transaction) {

    }
}
