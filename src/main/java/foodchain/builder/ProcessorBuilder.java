package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.Processor;

/**
 * The type Processor builder.
 */
public class ProcessorBuilder extends PartyBuilder {
    private final int balance;
    private final String name;
    private final int margin;

    /**
     * Instantiates a new Processor builder.
     *
     * @param name    the name
     * @param balance the balance
     * @param margin  the margin
     */
    public ProcessorBuilder(String name, int balance, int margin) {
        this.name = name;
        this.balance = balance;
        this.margin = margin;
    }

    Party createParty() {
        return new Processor(name, balance, margin);
    }
}
