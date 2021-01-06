package foodchain.transactions;

import foodchain.party.Party;

public class GenesisTransaction extends Transaction{
    /**
     * Constructs transaction between parties.
     *
     * @param receiver the party which receives money/product.
     * @param sender   the party which sends money/product.
     */
    public GenesisTransaction(Party receiver, Party sender, Transaction previousTransaction) {
        super(receiver, sender, previousTransaction);
        previousTransaction = null;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.GENESIS;
    }

    @Override
    public String toString() {
        return "Hi im genesis block:)";
    }
}
