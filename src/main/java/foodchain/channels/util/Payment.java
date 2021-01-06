package foodchain.channels.util;

import foodchain.party.Party;

import java.util.UUID;

public class Payment implements RP{

    private final UUID id;
    private final Party sender;
    private final Party reciever;
    private final int money;

    public UUID getId() {
        return id;
    }

    public Party getSender() {
        return sender;
    }

    public Party getReciever() {
        return reciever;
    }

    public int getMoney() {
        return money;
    }

    public Payment(Party sender, Party reciever, int money) {
        this.id = UUID.randomUUID();
        this.sender = sender;
        this.reciever = reciever;
        this.money = money;
    }
}
