package foodchain.product.Products;

/**
 * The type Plant product.
 */
public class PlantProduct extends ProductType{


    public PlantProduct(float kg, PlantProducts plant) {
        super(kg, plant);

    }

    public ProductTypes getProductTypes() {
        return this.productTypes;
    }

    public float getQuantity() {
        return this.quantity;
    }
}
