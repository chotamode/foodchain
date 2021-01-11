package foodchain.channels.util;

import foodchain.party.Party;

public class Payment {

    private final Party sender;
    private final Party reciever;
    private final float money;

    public Payment(Party sender, Party reciever, float money) {
        this.sender = sender;
        this.reciever = reciever;
        this.money = money;
    }

    public Party getSender() {
        return sender;
    }

    public Party getReciever() {
        return reciever;
    }

    public float getMoney() {
        return money;
    }
}
