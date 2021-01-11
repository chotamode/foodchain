package foodchain.party;

import foodchain.channels.Channel;
import foodchain.channels.util.Request;
import foodchain.transactions.Transaction;

/**
 * The interface Channel observer.
 */
public interface ChannelObserver {
    /**
     * Attaches new channels.
     *
     * @param channel the channel
     */
    void attach(Channel channel);

    /**
     * Detaches channels.
     *
     * @param channel the channel
     */
    void detach(Channel channel);

    /**
     * Updates the List of requests in each party by notifyAll.
     *
     * @param request the request
     */
    void update(Request request);

    /**
     * Updates purses of parties and updates last transaction.
     *
     * @param transaction the transaction
     */
    void update(Transaction transaction);
}
