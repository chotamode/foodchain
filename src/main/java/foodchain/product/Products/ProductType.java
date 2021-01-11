package foodchain.product.Products;

import foodchain.product.Product;

/**
 * The interface Product type.
 */
public abstract class ProductType {

    protected float quantity;
    protected final ProductTypes productTypes;

    ProductType(float quantity, ProductTypes productTypes) {
        this.quantity = quantity;
        this.productTypes = productTypes;
    }

    public abstract ProductTypes getProductTypes();

    public abstract float getQuantity();

    public void reduce(float amount) {
        this.quantity = this.quantity - amount;
    }

    public void addToCounters(float amount) {
        this.quantity = this.quantity + amount;
    }

    public float getCost() {
        return this.productTypes.getCost() * this.quantity;
    }
}
