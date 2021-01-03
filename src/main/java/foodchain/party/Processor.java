package foodchain.party;

public class Processor extends Party{

    private static final PartyType partyType = PartyType.PROCESSOR;

    public Processor(String name, int balance) {
        super(name, balance, partyType);
    }
}
