package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.farmer.Farmer;

public class FarmerBuilder extends PartyBuilder{
    private final int balance;
    private final String name;

    public FarmerBuilder(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    @Override
    Party createParty() {
        return new Farmer(name, balance);
    }
}