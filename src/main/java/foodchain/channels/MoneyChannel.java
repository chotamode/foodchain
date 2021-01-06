package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.channels.util.RP;
import foodchain.channels.util.Request;
import foodchain.party.ChannelObserver;
import foodchain.transactions.TransactionType;

import java.util.List;

public class MoneyChannel extends Channel{

    private List<Payment> payments;

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
        this.payments.add(payment);
    };
}
