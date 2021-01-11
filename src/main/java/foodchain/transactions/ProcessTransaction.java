package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

public class ProcessTransaction extends Transaction {

    private final TransactionType type = TransactionType.PROCESS;
    private final Product product;

    public ProcessTransaction(Party creator, Product product, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.product = product;
    }

    @Override
    public TransactionType getTransactionType() {
        return null;
    }

    public TransactionType getType() {
        return type;
    }
}
