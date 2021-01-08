package foodchain.party;

import foodchain.channels.util.Request;

/**
 * The type Customer.
 */
public class Customer extends Party {

    public Customer(String name, int balance) {
        super(name, balance, 0);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.CUSTOMER;
    }

    @Override
    public void processRequest(Request request) {
        System.out.println("Customer can't process request");
    }

    @Override
    protected boolean canProcessRequest(Request request) {
        System.out.println("Customer can't process request");
        return false;
    }

}