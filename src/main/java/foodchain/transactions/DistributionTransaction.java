package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;
import foodchain.product.Products.ProductType;

public class DistributionTransaction extends Transaction{

    private final TransactionType type = TransactionType.DISTRIBUTION;
    private final ProductType productType;
    private final Party receiver;
    private final Party distributor;

    public DistributionTransaction(Party creator, Party receiver,Party distributor, ProductType productType, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.receiver = receiver;
        this.productType = productType;
        this.distributor = distributor;
    }

    public ProductType getProductType() {
        return productType;
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
