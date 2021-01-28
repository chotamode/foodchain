package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;
import foodchain.product.Products.ProductType;

import java.util.UUID;

/**
 * The type Sell transaction.
 */
    public class SellTransaction extends Transaction {

    private final TransactionType type = TransactionType.SELL;
    private final Party receiver;
    private final UUID uuid;
    private final ProductType productType;

    /**
     * Instantiates a new Sell transaction.
     *
     * @param seller              the seller
     * @param customer            the customer
     * @param product             the product
     * @param productType         the product type
     * @param previousTransaction the previous transaction
     */
    public SellTransaction(Party seller, Party customer, Product product, ProductType productType, Transaction previousTransaction) {
        super(seller, previousTransaction);
        this.receiver = customer;
        this.uuid = product.getUuid();
        this.productType = productType;
    }

    /**
     * Gets receiver.
     *
     * @return the receiver
     */
    public Party getReceiver() {
        return receiver;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public float getAmount() {
        return productType.getQuantity();
    }

    @Override
    public TransactionType getTransactionType() {
        return type;
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Gets product type.
     *
     * @return the product type
     */
    public ProductType getProductType() {
        return productType;
    }
}
