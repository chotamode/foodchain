package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

/**
 * The type Product transaction.
 */
public class ProductTransaction extends Transaction {

    private final Product product;
    private final float amount;
    private final Party receiver;

    /**
     * Instantiates a new Product transaction.
     *
     * @param creator             the creator
     * @param receiver            the receiver
     * @param amount              the amount
     * @param product             the product
     * @param previousTransaction the previous transaction
     */
    public ProductTransaction(Party creator, Party receiver, float amount, Product product, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.product = product;
        this.amount = amount;

        this.receiver = receiver;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    public TransactionType getTransactionType() {
        return TransactionType.PRODUCT;
    }

    @Override
    public String toString() {
        return "ProductTransaction{" +
                "product=" + product +
                ", amount=" + amount +
                ", creator=" + getCreator() +
                ", receiver=" + receiver +
                '}';
    }
}
