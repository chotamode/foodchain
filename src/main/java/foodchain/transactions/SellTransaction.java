package foodchain.transactions;

import foodchain.party.Party;
import foodchain.product.Product;
import foodchain.product.Products.ProductType;

import java.util.UUID;

public class SellTransaction extends Transaction{

    private final TransactionType type = TransactionType.SELL;
    private final Party receiver;
    private final UUID uuid;
    private final ProductType productType;

    public SellTransaction(Party seller, Party customer, UUID uuid, ProductType productType, Transaction previousTransaction) {
        super(seller, previousTransaction);
        this.receiver = customer;
        this.uuid = uuid;
        this.productType = productType;
    }

    public Party getReceiver() {
        return receiver;
    }

    public float getAmount() {
        return productType.getQuantity();
    }

    @Override
    public TransactionType getTransactionType() {
        return type;
    }

    public UUID getUuid() {
        return uuid;
    }

    public ProductType getProductType() {
        return productType;
    }
}
