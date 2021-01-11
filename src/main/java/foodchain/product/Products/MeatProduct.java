package foodchain.product.Products;

/**
 * The type Meat product.
 */
public class MeatProduct extends ProductType {

    public MeatProduct(float Kg, MeatProducts meatProducts) {
        super(Kg, meatProducts);
    }

    public ProductTypes getProductTypes() {
        return this.productTypes;
    }

    public float getQuantity() {
        return this.quantity;
    }
}
