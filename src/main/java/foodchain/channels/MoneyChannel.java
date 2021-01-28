package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.channels.util.Request;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.TransactionType;

/**
 * The type Money channel.
 */
public class MoneyChannel extends Channel {

    /**
     * Instantiates a new Money channel.
     *
     * @param type the type
     */
    public MoneyChannel(TransactionType type) {
        super(type);
    }

    @Override
    public void notifyAllParties(Request request) {
        System.out.println("You can't send requests in Money Channel");
    }

    /**
     * Adds payment transaction to the linked list of
     * transactions (each transaction has field previous transaction).
     *
     * @param payment the payment
     */
    public void addPaymentTransaction(Payment payment) {
        if (payment.getSender().getBalance() < payment.getMoney()) {
            System.out.println(payment.getSender().getName() + " does not have enough money!");
            return;
        }
        if (!subscribers.contains(payment.getSender())) {
            System.out.println("Sender" + payment.getSender().getName() + " is not subscribed");
            return;
        }
        if (!subscribers.contains(payment.getReceiver())) {
            System.out.println("Reciever" + payment.getReceiver().getName() + " is not subscribed");
            return;
        }
        this.lastTransaction = new MoneyTransaction(payment.getSender(),
                payment.getReceiver(), payment.getMoney(), this.lastTransaction);
        notifyAllParties(lastTransaction, subscribers);
    }
}
