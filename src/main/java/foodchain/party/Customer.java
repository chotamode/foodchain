package foodchain.party;

import foodchain.product.Product;
import foodchain.transactions.Transaction;

/**
 * The type Customer.
 */
public class Customer extends Party{

    private static final PartyType partyType = PartyType.CUSTOMER;

    /**
     * Instantiates a new Customer.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Customer(String name, int balance) {
        super(name, balance, partyType);
    }


    public void sendProduct(Product product) {

    }
}
