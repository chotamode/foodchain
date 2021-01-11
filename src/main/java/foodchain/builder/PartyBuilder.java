package foodchain.builder;

import foodchain.party.Party;

public abstract class PartyBuilder {
    protected Party party;

    abstract Party createParty();
}
