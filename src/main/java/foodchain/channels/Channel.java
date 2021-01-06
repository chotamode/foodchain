package foodchain.channels;

import foodchain.party.ChannelObserver;
import foodchain.transactions.GenesisTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.LinkedList;
import java.util.List;

public abstract class Channel implements PartyObservable{

    private TransactionType transactionType;
    private GenesisTransaction genesisTransaction = new GenesisTransaction(null, null);
    private Transaction lastTransaction = genesisTransaction;
    protected List<ChannelObserver> subscribers;

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Channel(TransactionType type) {
        this.subscribers = new LinkedList<ChannelObserver>();
        this.transactionType = type;
    }
}
