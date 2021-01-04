package foodchain.channels;

/**
 * The interface Party observable.
 */
public interface PartyObservable {

    /**
     * Notifies all observing parties about changes in channel.
     */
    void notifyAllParties();
}
