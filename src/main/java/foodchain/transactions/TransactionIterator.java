package foodchain.transactions;

import java.util.Iterator;

public class TransactionIterator{

    private final Transaction root_transaction;
    private Transaction transaction;

    public TransactionIterator(Transaction root_transaction) {
        this.root_transaction = root_transaction;
        this.transaction = root_transaction;
    }

    public boolean hasNext() {
        return this.transaction != null;
    }

    public Transaction next() {
        if(hasNext()){
            return transaction.getPreviousTransaction();
        }else{
            return null;
        }
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
