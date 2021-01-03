package foodchain.party;

public class Storage extends Party{

    private static final PartyType partyType = PartyType.STORAGE;

    public Storage(String name, int balance) {
        super(name, balance, partyType);
    }
}
