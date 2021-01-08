package foodchain.builder;

import foodchain.party.Seller;
import foodchain.party.Party;

public class SellerBuilder extends PartyBuilder{
    private final int balance;
    private final String name;

    SellerBuilder(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    @Override
    Party createParty() {
        return new Seller(name, balance, margin);
    }
}
