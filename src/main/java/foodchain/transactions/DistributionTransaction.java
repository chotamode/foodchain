package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;

public class DistributionTransaction extends Transaction{

    private final TransactionType type = TransactionType.DISTRIBUTION;
    private final Product product;
    private final Party receiver;
    private final float amount;

    public DistributionTransaction(Party creator, Party receiver,  Product product, float amount, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.product = product;
        this.receiver = receiver;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Product getProduct() {
        return product;
    }

    public Party getReceiver() {
        return receiver;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public TransactionType getTransactionType() {
        return type;
    }
}
