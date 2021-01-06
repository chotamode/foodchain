package foodchain.channels.util;

import foodchain.party.Party;

import java.util.UUID;

public class Payment implements RP{
    public UUID getId() {
        return id;
    }

    public Party getSender() {
        return sender;
    }

    public Party getReciever() {
        return reciever;
    }

    public float getAmount() {
        return amount;
    }

    public Payment(Party sender, Party reciever, float amount) {
        this.id = UUID.randomUUID();
        this.sender = sender;
        this.reciever = reciever;
        this.amount = amount;
    }

    private final UUID id;
    private final Party sender;
    private final Party reciever;
    private final float amount;
}
