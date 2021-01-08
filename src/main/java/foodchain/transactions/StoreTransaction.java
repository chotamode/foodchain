package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

public class StoreTransaction extends Transaction{

    private final int days;
    private final Product product;
    private final TransactionType transactionType = TransactionType.STORE;

    public StoreTransaction(Party creator, int days, Product product, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.days = days;
        this.product = product;
    }

    public int getDays() {
        return days;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public TransactionType getTransactionType() {
        return transactionType;
    }
}
