package foodchain.transactions;

import foodchain.party.Party;

public class GenesisTransaction extends Transaction{

    private final TransactionType type = TransactionType.GENESIS;

    public GenesisTransaction(Party creator, Transaction previousTransaction) {
        super(creator, previousTransaction);
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.GENESIS;
    }

    @Override
    public String toString() {
        return "Hi im genesis block:)";
    }

    public TransactionType getType() {
        return type;
    }

}
