package foodchain.channels;

import foodchain.channels.util.RP;
import foodchain.channels.util.Request;
import foodchain.party.ChannelObserver;

/**
 * The interface Party observable.
 */
public interface PartyObservable {

    /**
     *
     * @param channelObserver the observer to attach
     */
    void attach(ChannelObserver channelObserver);

    /**
     *
     * @param channelObserver the observer to detach
     */
    void detach(ChannelObserver channelObserver);


    /**
     * Notifies all observing parties about changes in channel.
     */
    void notifyAllParties(RP rp);
}
