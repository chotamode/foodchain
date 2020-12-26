package foodchain.Builder;

import foodchain.Party.Party;
import foodchain.Party.Processor;

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
