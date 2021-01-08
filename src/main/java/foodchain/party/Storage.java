package foodchain.party;

import foodchain.channels.util.Request;
import foodchain.product.Product;

/**
 * The type Storage.
 */
public class Storage extends Party{

    private static final PartyType partyType = PartyType.STORAGE;

    /**
     * Instantiates a new Storage.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Storage(String name, int balance) {
        super(name, balance, margin);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.STORAGE;
    }

    @Override
    public void processRequest(Request request) {

    }

    public void sendProduct(Product product) {

    }
}
