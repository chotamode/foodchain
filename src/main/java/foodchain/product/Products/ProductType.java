package foodchain.product.Products;

import foodchain.product.Product;

/**
 * The interface Product type.
 */
public abstract class ProductType {

    protected float quantity;
    protected final ProductTypes productTypes;

    ProductType(float quantity, ProductTypes productTypes){
        this.quantity = quantity;
        this.productTypes = productTypes;
    };

    public abstract ProductTypes getProductTypes();

    public abstract float getQuantity();

    public abstract void reduce(float amount);

    public abstract float getCost();
}
