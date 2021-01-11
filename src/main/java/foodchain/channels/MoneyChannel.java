package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.channels.util.Request;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.TransactionType;

public class MoneyChannel extends Channel {

    public MoneyChannel(TransactionType type) {
        super(type);
    }

    @Override
    public void notifyAllParties(Request request) {
        System.out.println("You can't send requests in Money Channel");
    }

    public void addPaymentTransaction(Payment payment) {
        if (payment.getSender().getBalance() < payment.getMoney()) {
            System.out.println(payment.getSender().getName() + " does not have enough money!");
            return;
        }
        if (!subscribers.contains(payment.getSender())) {
            System.out.println("Sender" + payment.getSender().getName() + " is not subscribed");
            return;
        }
        if (!subscribers.contains(payment.getReciever())) {
            System.out.println("Reciever" + payment.getReciever().getName() + " is not subscribed");
            return;
        }
        this.lastTransaction = new MoneyTransaction(payment.getSender(),
                payment.getReciever(), payment.getMoney(), this.lastTransaction);
        notifyAllParties(lastTransaction, subscribers);
    }
}
