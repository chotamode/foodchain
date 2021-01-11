package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.Processor;

public class ProcessorBuilder extends PartyBuilder {
    private final int balance;
    private final String name;
    private final int margin;

    public ProcessorBuilder(String name, int balance, int margin) {
        this.name = name;
        this.balance = balance;
        this.margin = margin;
    }

    Party createParty() {
        return new Processor(name, balance, margin);
    }
}
