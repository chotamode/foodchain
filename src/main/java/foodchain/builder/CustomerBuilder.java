package foodchain.builder;

import foodchain.party.Customer;
import foodchain.party.Party;

/**
 * The type Customer builder.
 */
public class CustomerBuilder extends PartyBuilder {
    private final int balance;
    private final String name;

    /**
     * Instantiates a new Customer builder.
     *
     * @param name    the name
     * @param balance the balance
     */
    CustomerBuilder(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    Party createParty() {
        return new Customer(name, balance);
    }
}
