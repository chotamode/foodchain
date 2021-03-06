package foodchain.channels;

import foodchain.party.ChannelObserver;
import foodchain.party.Party;
import foodchain.transactions.GenesisTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Channel.
 */
public abstract class Channel implements PartyObservable {
    protected TransactionType transactionType;
    protected GenesisTransaction genesisTransaction = new GenesisTransaction(null, null);
    protected Transaction lastTransaction = genesisTransaction;
    protected List<ChannelObserver> subscribers;
    protected Map<Party, Integer> doubleSpending = new HashMap<>();

    /**
     * Instantiates a new Channel.
     *
     * @param type the transaction type
     */
    public Channel(TransactionType type) {
        this.subscribers = new LinkedList<>();
        this.transactionType = type;
    }

    /**
     * Gets transaction type of this transaction.
     *
     * @return the transaction type
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public void attach(ChannelObserver channelObserver) {
        if (!subscribers.contains(channelObserver)) {
            subscribers.add(channelObserver);
            channelObserver.attach(this);
        }

    }

    @Override
    public void detach(ChannelObserver channelObserver) {
        if (subscribers.contains(channelObserver)) {
            subscribers.remove(channelObserver);
            channelObserver.detach(this);
        }

    }

}
