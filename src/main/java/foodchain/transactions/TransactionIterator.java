package foodchain.transactions;

import java.util.Iterator;

public class TransactionIterator implements Iterator {

    protected final Transaction root_transaction;
    protected Transaction transaction;

    public TransactionIterator(Transaction root_transaction) {
        this.root_transaction = root_transaction;
        this.transaction = root_transaction;
    }

    @Override
    public boolean hasNext() {
        return this.transaction != null;
    }

    @Override
    public Transaction next() {
        if(hasNext()){
            return transaction.getPreviousTransaction();
        }else{
            return null;
        }
    }
}
