package foodchain.party;

import foodchain.product.Product;
import foodchain.transactions.Transaction;

/**
 * The type Processor.
 */
public class Processor extends Party{

    private static final PartyType partyType = PartyType.PROCESSOR;

    /**
     * Instantiates a new Processor.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Processor(String name, int balance) {
        super(name, balance, partyType);
    }

    public void sendProduct(Product product) {

    }
}
