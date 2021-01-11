package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.Storage;

public class StorageBuilder extends PartyBuilder {
    private final int balance;
    private final String name;
    private final int margin;

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
