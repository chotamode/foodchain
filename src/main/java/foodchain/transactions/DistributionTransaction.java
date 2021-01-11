package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

/**
 * The type Distribution transaction.
 */
public class DistributionTransaction extends Transaction {

    private final TransactionType type = TransactionType.DISTRIBUTION;
    private final Product product;
    private final Party receiver;
    private final Party distributor;

    /**
     * Instantiates a new Distribution transaction.
     *
     * @param creator             the creator
     * @param receiver            the receiver
     * @param distributor         the distributor
     * @param product             the product
     * @param previousTransaction the previous transaction
     */
    public DistributionTransaction(Party creator, Party receiver, Party distributor, Product product, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.receiver = receiver;
        this.product = product;
        this.distributor = distributor;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Gets receiver.
     *
     * @return the receiver
     */
    public Party getReceiver() {
        return receiver;
    }

    @Override
    public TransactionType getTransactionType() {
        return type;
    }

    /**
     * Gets distributor.
     *
     * @return the distributor
     */
    public Party getDistributor() {
        return distributor;
    }
}
