package foodchain.transactions;

import foodchain.party.Party;

/**
 * The type Genesis transaction.
 */
public class GenesisTransaction extends Transaction {

    private final TransactionType type = TransactionType.GENESIS;

    /**
     * Instantiates a new Genesis transaction.
     *
     * @param creator             the creator
     * @param previousTransaction the previous transaction
     */
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

    /**
     * Gets type.
     *
     * @return the type
     */
    public TransactionType getType() {
        return type;
    }

}
