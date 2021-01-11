package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

public class CreateProductTransaction extends Transaction {

    private final Product product;

    private final TransactionType transactionType = TransactionType.CREATE_PRODUCT;

    public CreateProductTransaction(Party creator, Product product, Transaction previousTransaction) {
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
