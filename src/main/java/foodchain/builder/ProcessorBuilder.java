package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.Processor;

public class ProcessorBuilder extends PartyBuilder{
    private final int balance;
    private final String name;

    public ProcessorBuilder(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    Party createParty() {
        return new Processor(name, balance);
    }
}
