package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.Distributor;

public class DistributorBuilder extends PartyBuilder{
    private final int balance;
    private final String name;
    private final int margin;

    public DistributorBuilder(String name, int balance, int margin) {
        this.name = name;
        this.balance = balance;
        this.margin = margin;
    }

    @Override
    Party createParty() {
        return new Distributor(name, balance, margin);
    }
}
