package foodchain.channels.util;

import foodchain.party.Party;

/**
 * The type Payment.
 */
public class Payment {

    private final Party sender;
    private final Party receiver;
    private final float money;

    /**
     * Instantiates a new Payment.
     *
     * @param sender   the sender
     * @param receiver the reciever
     * @param money    the money
     */
    public Payment(Party sender, Party receiver, float money) {
        this.sender = sender;
        this.receiver = receiver;
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
    public Party getReceiver() {
        return receiver;
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
