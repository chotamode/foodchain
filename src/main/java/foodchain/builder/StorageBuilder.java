package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.Storage;

/**
 * The type Storage builder.
 */
public class StorageBuilder extends PartyBuilder {
    private final int balance;
    private final String name;
    private final int margin;

    /**
     * Instantiates a new Storage builder.
     *
     * @param name    the name
     * @param balance the balance
     * @param margin  the margin
     */
    StorageBuilder(String name, int balance, int margin) {
        this.name = name;
        this.balance = balance;
        this.margin = margin;
    }

    @Override
    Party createParty() {
        return new Storage(name, balance, margin);
    }
}
