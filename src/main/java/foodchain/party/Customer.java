package foodchain.party;

public class Customer extends Party{

    private static final PartyType partyType = PartyType.CUSTOMER;

    public Customer(String name, int balance) {
        super(name, balance, partyType);
    }
}
