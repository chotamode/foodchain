package foodchain.party;

import foodchain.channels.util.Request;
import foodchain.product.Product;

/**
 * The type Processor.
 */
public class Processor extends Party{

    /**
     * Instantiates a new Processor.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Processor(String name, int balance, int margin) {
        super(name, balance, margin);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.PROCESSOR;
    }

    @Override
    public void processRequest(Request request) {

    }

    public void sendProduct(Product product) {

    }
}
