package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

public class StoreTransaction extends Transaction{


    private final Product product;
    private final TransactionType transactionType = TransactionType.STORE;

    public StoreTransaction(Party creator, Product product, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public TransactionType getTransactionType() {
        return transactionType;
    }
}
