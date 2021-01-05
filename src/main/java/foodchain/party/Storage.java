package foodchain.party;

import foodchain.product.Product;
import foodchain.transactions.Transaction;

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
        super(name, balance, partyType);
    }

    public void sendProduct(Product product) {

    }
}
