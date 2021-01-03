package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.Storage;

public class StorageBuilder extends PartyBuilder{
    private final int balance;
    private final String name;

    StorageBuilder(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    @Override
    Party createParty() {
        return new Storage(name, balance);
    }
}
