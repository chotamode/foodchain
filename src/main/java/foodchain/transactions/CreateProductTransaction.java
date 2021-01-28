package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

/**
 * The type Create product transaction.
 */
public class CreateProductTransaction extends Transaction {

    private final Product product;
    private final TransactionType transactionType = TransactionType.CREATE_PRODUCT;

    /**
     * Instantiates a new Create product transaction.
     *
     * @param creator             the creator
     * @param product             the product
     * @param previousTransaction the previous transaction
     */
    public CreateProductTransaction(Party creator, Product product, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.product = product;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    @Override
    public TransactionType getTransactionType() {
        return transactionType;
    }
}
