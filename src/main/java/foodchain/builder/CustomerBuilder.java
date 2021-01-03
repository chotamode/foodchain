package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.Customer;

public class CustomerBuilder extends PartyBuilder{
    private final int balance;
    private final String name;

    CustomerBuilder(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    @Override
    Party createParty() {
        return new Customer(name, balance);
    }
}
