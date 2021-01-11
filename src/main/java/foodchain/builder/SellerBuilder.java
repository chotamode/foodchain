package foodchain.builder;

import foodchain.party.Seller;
import foodchain.party.Party;

/**
 * The type Seller builder.
 */
public class SellerBuilder extends PartyBuilder {
    private final int balance;
    private final String name;
    private final int margin;

    /**
     * Instantiates a new Seller builder.
     *
     * @param name    the name
     * @param balance the balance
     * @param margin  the margin
     */
    SellerBuilder(String name, int balance, int margin) {
        this.name = name;
        this.balance = balance;
        this.margin = margin;
    }

    @Override
    Party createParty() {
        return new Seller(name, balance, margin);
    }
}
