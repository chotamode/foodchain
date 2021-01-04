package foodchain.party;

import foodchain.ObserverObservable.ChannelObserver;

/**
 * The type Party.
 */
public abstract class Party implements ChannelObserver {
    private int balance;
    private final String name;
    private  final PartyType partyType;

    /**
     * Instantiates a new Party.
     *
     * @param balance   the balance
     * @param name      the name
     * @param partyType the party type
     */
    public Party(int balance, String name, PartyType partyType) {
        this.balance = balance;
        this.name = name;
        this.partyType = partyType;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets party type.
     *
     * @return the party type
     */
    public PartyType getPartyType() {
        return partyType;
    }

    /**
     * Instantiates a new Party.
     *
     * @param name      the name
     * @param balance   the balance
     * @param partyType the party type
     */
    protected Party(String name, int balance, PartyType partyType) {
        this.name = name;
        this.balance = balance;

        this.partyType = partyType;
    }

}
