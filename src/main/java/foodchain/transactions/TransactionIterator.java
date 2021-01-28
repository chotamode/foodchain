package foodchain.transactions;

/**
 * The type Transaction iterator.
 */
public class TransactionIterator {

    private final Transaction root_transaction;
    private Transaction transaction;

    /**
     * Instantiates a new Transaction iterator.
     *
     * @param root_transaction the root transaction
     */
    public TransactionIterator(Transaction root_transaction) {
        this.root_transaction = root_transaction;
        this.transaction = root_transaction;
    }

    /**
     * Gets root transaction.
     *
     * @return the root transaction
     */
    public Transaction getRoot_transaction() {
        return root_transaction;
    }

    /**
     * Has next boolean.
     * checks if this transaction is not null
     *
     * @return the boolean
     */
    public boolean hasNext() {
        return this.transaction != null;
    }

    /**
     * Next.
     * Sets this transaction to previous transaction
     */
    public void next() {
        if (hasNext()) {
            this.transaction = transaction.getPreviousTransaction();
        }
    }

    /**
     * Gets transaction.
     *
     * @return the transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }
}
