package foodchain.Builder;

import foodchain.Party.Party;
import foodchain.Party.Storage;

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
