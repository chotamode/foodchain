package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

public class DistributionTransaction extends Transaction {

    private final TransactionType type = TransactionType.DISTRIBUTION;
    private final Product product;
    private final Party receiver;
    private final Party distributor;

    public DistributionTransaction(Party creator, Party receiver, Party distributor, Product product, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.receiver = receiver;
        this.product = product;
        this.distributor = distributor;
    }

    public Product getProduct() {
        return this.product;
    }

    public TransactionType getType() {
        return type;
    }

    public Party getReceiver() {
        return receiver;
    }

    @Override
    public TransactionType getTransactionType() {
        return type;
    }

    public Party getDistributor() {
        return distributor;
    }
}
