package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.channels.util.RP;
import foodchain.channels.util.Request;
import foodchain.party.ChannelObserver;
import foodchain.party.Party;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.ProductTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Product channel.
 */
public class ProductChannel extends Channel {

    List<Request> requests = new LinkedList<Request>();

    public ProductChannel(TransactionType type) {
        super(type);
        this.subscribers = new LinkedList<ChannelObserver>();
    }

    @Override
    public void attach(ChannelObserver channelObserver) {
        subscribers.add(channelObserver);
        channelObserver.attach(this);
    }

    @Override
    public void detach(ChannelObserver channelObserver) {
        subscribers.remove(channelObserver);
        channelObserver.detach(this);
    }

    @Override
    public void notifyAllParties(RP request) {
        for (ChannelObserver s:subscribers
        ) {
            s.update(request);
        }
    }

    public void addRequest(Request request){
        notifyAllParties(request);
        this.requests.add(request);
    }

    public void addTransaction(Party sender, Request request){
        this.lastTransaction = new ProductTransaction(
                request.getReciever(),
                sender,
                request.getProduct(),
                request.getAmount(),
                this.lastTransaction
        );
    };
}
