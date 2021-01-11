package foodchain.transactions;

public class TransactionIterator {

    private final Transaction root_transaction;
    private Transaction transaction;

    public TransactionIterator(Transaction root_transaction) {
        this.root_transaction = root_transaction;
        this.transaction = root_transaction;
    }

    public boolean hasNext() {
        return this.transaction != null;
    }

    public void next() {
        if (hasNext()) {
            this.transaction = transaction.getPreviousTransaction();
        }
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
