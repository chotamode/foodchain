package foodchain.channels.util;

import foodchain.product.Product;

import java.util.UUID;

public class Request implements RP{

    private final UUID id;
    private final Product product;
    private final float amount;

    public Request(Product product, float amount) {
        this.id = UUID.randomUUID();
        this.product = product;
        this.amount = amount;
    }

    public float getCost(){
        return amount * product.getProductType().getProductTypes().getCost();
    }

    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public float getAmount() {
        return amount;
    }

    public void setCompleted() {
        this.completed = true;
    }

    private boolean completed = false;
}
