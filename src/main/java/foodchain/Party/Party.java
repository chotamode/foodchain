package foodchain.Party;

import foodchain.ObserverObservable.ChannelObserver;

public abstract class Party implements ChannelObserver {
    private int balance;
    private final String name;

    protected Party(String name, int balance) {
        this.name = name;
        this.balance = balance;

    }

}
