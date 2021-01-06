package foodchain.channels.util;

import foodchain.product.Product;

import java.util.UUID;

public class Request implements RP{

    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public float getAmount() {
        return amount;
    }

    public Request(Product product, float amount) {
        this.id = UUID.randomUUID();
        this.product = product;
        this.amount = amount;
    }

    private final UUID id;
    private final Product product;
    private final float amount;

    public void setCompleted() {
        this.completed = true;
    }

    private boolean completed = false;
}
