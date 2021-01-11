package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

/**
 * The type Process transaction.
 */
public class ProcessTransaction extends Transaction {

    private final TransactionType type = TransactionType.PROCESS;
    private final Product product;

    /**
     * Instantiates a new Process transaction.
     *
     * @param creator             the creator
     * @param product             the product
     * @param previousTransaction the previous transaction
     */
    public ProcessTransaction(Party creator, Product product, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.product = product;
    }

    @Override
    public TransactionType getTransactionType() {
        return null;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TransactionType getType() {
        return type;
    }
}
