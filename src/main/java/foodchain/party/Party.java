package foodchain.party;

import foodchain.ObserverObservable.ChannelObserver;

public abstract class Party implements ChannelObserver {
    private int balance;
    private final String name;
    private  final PartyType partyType;

    public Party(int balance, String name, PartyType partyType) {
        this.balance = balance;
        this.name = name;
        this.partyType = partyType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public PartyType getPartyType() {
        return partyType;
    }

    protected Party(String name, int balance, PartyType partyType) {
        this.name = name;
        this.balance = balance;

        this.partyType = partyType;
    }

}
