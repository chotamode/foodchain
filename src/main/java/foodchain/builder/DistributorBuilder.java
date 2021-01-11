package foodchain.builder;

import foodchain.party.Distributor;
import foodchain.party.Party;

/**
 * The type Distributor builder.
 */
public class DistributorBuilder extends PartyBuilder {
    private final int balance;
    private final String name;
    private final int margin;

    /**
     * Instantiates a new Distributor builder.
     *
     * @param name    the name
     * @param balance the balance
     * @param margin  the margin
     */
    public DistributorBuilder(String name, int balance, int margin) {
        this.name = name;
        this.balance = balance;
        this.margin = margin;
    }

    @Override
    Party createParty() {
        return new Distributor(name, balance, margin);
    }
}
