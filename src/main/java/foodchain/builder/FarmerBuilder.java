package foodchain.builder;

import foodchain.party.Party;
import foodchain.party.farmer.Farmer;

/**
 * The type Farmer builder.
 */
public class FarmerBuilder extends PartyBuilder {
    private final int balance;
    private final String name;
    private final int margin;

    /**
     * Instantiates a new Farmer builder.
     *
     * @param name    the name
     * @param balance the balance
     * @param margin  the margin
     */
    public FarmerBuilder(String name, int balance, int margin) {
        this.name = name;
        this.balance = balance;
        this.margin = margin;
    }

    @Override
    Party createParty() {
        return new Farmer(name, balance, margin);
    }
}
