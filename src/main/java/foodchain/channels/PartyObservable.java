package foodchain.channels;

public interface PartyObservable {

    /**
     * Notify all observing parties about changes in channel.
     */
    void notifyAllParties();
}
