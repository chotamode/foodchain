package foodchain.party;

public class Seller extends Party{

    private static final PartyType partyType = PartyType.SELLER;

    public Seller(String name, int balance) {
        super(name, balance, partyType);
    }
}
