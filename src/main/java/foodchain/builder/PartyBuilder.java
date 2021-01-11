package foodchain.builder;

import foodchain.party.Party;

/**
 * The type Party builder.
 */
public abstract class PartyBuilder {

    /**
     * Creates party type of Party.
     *
     * @return the party
     */
    abstract Party createParty();
}
