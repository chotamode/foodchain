package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

/**
 * The type Product transaction.
 */
public class ProductTransaction extends Transaction{
    private final Product product;
    private final float amount;

    /**
     * Constructs transaction between parties.
     *  @param receiver the party which receives money/product.
     * @param sender   the party which sends money/product.
     * @param product  the product
     * @param amount
     */
    public ProductTransaction(Party receiver, Party sender, Product product, float amount, Transaction previousTransaction) {
        super(receiver, sender, previousTransaction);
        this.product = product;
        this.amount = amount;
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
                ", receiver=" + receiver +
                ", sender=" + sender +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
