package foodchain.party;

public class Distributor extends Party{

    private static final PartyType partyType = PartyType.DISTRIBUTOR;

    public Distributor(String name, int balance) {
        super(name, balance, partyType);
    }
}
