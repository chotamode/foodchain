package foodchain.channels;

import foodchain.Reporter;
import foodchain.channels.util.Request;
import foodchain.party.ChannelObserver;
import foodchain.transactions.Transaction;

import java.util.List;

/**
 * The interface Party observable.
 */
public interface PartyObservable {
    Reporter reporter = Reporter.getReporter();

    /**
     * @param channelObserver the observer to attach
     */
    void attach(ChannelObserver channelObserver);

    /**
     * @param channelObserver the observer to detach
     */
    void detach(ChannelObserver channelObserver);


    /**
     * Notifies all observing parties about changes in channel.
     */
    void notifyAllParties(Request request);

    default void notifyAllParties(Transaction transaction, List<ChannelObserver> subscribers) {
        for (ChannelObserver o : subscribers
        ) {
            o.update(transaction);
        }
        reporter.addTransactionReport(transaction.getClass().getSimpleName() + ": " + transaction.toString());
    }
}
