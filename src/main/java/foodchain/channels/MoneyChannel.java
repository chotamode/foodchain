package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.channels.util.RP;
import foodchain.party.ChannelObserver;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.TransactionType;

public class MoneyChannel extends Channel{

    public MoneyChannel(TransactionType type) {
        super(type);
    }

    @Override
    public void attach(ChannelObserver channelObserver) {
        subscribers.add(channelObserver);
    }

    @Override
    public void detach(ChannelObserver channelObserver) {
        subscribers.remove(channelObserver);
    }

    @Override
    public void notifyAllParties(RP payment) {
        for (ChannelObserver s:subscribers
        ) {
            s.update(payment);
        }
    }

    public void addPayment(Payment payment){
        notifyAllParties(payment);
        this.lastTransaction = new MoneyTransaction(payment.getReciever(),
                payment.getSender(), payment.getMoney(), this.lastTransaction);
    };
}
