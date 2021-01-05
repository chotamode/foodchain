package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

/**
 * The type Product transaction.
 */
public class ProductTransaction extends Transaction{
    private final Product product;

    /**
     * Constructs transaction between parties.
     *
     * @param receiver the party which receives money/product.
     * @param sender   the party which sends money/product.
     * @param product  the product
     */
    public ProductTransaction(Party receiver, Party sender, Product product) {
        super(receiver, sender);
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

    public TransactionType getTransactionType() {
        return TransactionType.PRODUCT;
    }
}
