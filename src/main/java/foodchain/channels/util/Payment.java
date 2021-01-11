package foodchain.channels.util;

import foodchain.party.Party;

/**
 * The type Payment.
 */
public class Payment {

    private final Party sender;
    private final Party reciever;
    private final float money;

    /**
     * Instantiates a new Payment.
     *
     * @param sender   the sender
     * @param reciever the reciever
     * @param money    the money
     */
    public Payment(Party sender, Party reciever, float money) {
        this.sender = sender;
        this.reciever = reciever;
        this.money = money;
    }

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public Party getSender() {
        return sender;
    }

    /**
     * Gets reciever.
     *
     * @return the reciever
     */
    public Party getReciever() {
        return reciever;
    }

    /**
     * Gets money.
     *
     * @return the money
     */
    public float getMoney() {
        return money;
    }
}
