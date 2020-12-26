package foodchain.Builder;

import foodchain.Party.Party;
import foodchain.Party.Distributor;

public class DistributorBuilder extends PartyBuilder{
    private final int balance;
    private final String name;

    public DistributorBuilder(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    Party createParty() {
        return new Distributor(name, balance);
    }
}
