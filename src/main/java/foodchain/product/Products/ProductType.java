package foodchain.product.Products;

/**
 * The interface Product type.
 */
public abstract class ProductType {

    protected final ProductTypes productTypes;
    protected float quantity;

    /**
     * Instantiates a new Product type.
     *
     * @param quantity     the quantity
     * @param productTypes the product types
     */
    ProductType(float quantity, ProductTypes productTypes) {
        this.quantity = quantity;
        this.productTypes = productTypes;
    }

    /**
     * Gets product types.
     *
     * @return the product types
     */
    public abstract ProductTypes getProductTypes();

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public abstract float getQuantity();

    /**
     * Reduces the amount product.
     *
     * @param amount the amount
     */
    public void reduce(float amount) {
        this.quantity = this.quantity - amount;
    }

    /**
     * Adds to counters.
     * USE JUST FOR: if Party have this
     * product and you want to unite the same product
     *
     * @param amount the amount
     */
    public void addToCounters(float amount) {
        this.quantity = this.quantity + amount;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public float getCost() {
        return this.productTypes.getCost() * this.quantity;
    }
}
