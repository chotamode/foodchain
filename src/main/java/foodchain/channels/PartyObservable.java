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
     * Attach.
     *
     * @param channelObserver the observer to attach
     */
    void attach(ChannelObserver channelObserver);

    /**
     * Detach.
     *
     * @param channelObserver the observer to detach
     */
    void detach(ChannelObserver channelObserver);


    /**
     * Notifies all observing parties about changes in channel.
     *
     * @param request the request
     */
    void notifyAllParties(Request request);

    /**
     * Notify all parties.
     *
     * @param transaction the transaction
     * @param subscribers the subscribers
     */
    default void notifyAllParties(Transaction transaction, List<ChannelObserver> subscribers) {
        for (ChannelObserver o : subscribers
        ) {
            o.update(transaction);
        }
        reporter.addTransactionReport(transaction.getClass().getSimpleName() + ": " + transaction.toString());
    }
}
