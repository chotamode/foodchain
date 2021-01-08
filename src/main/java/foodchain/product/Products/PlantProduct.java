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

    @Override
    public void reduce(float amount) {
        this.quantity = this.quantity - amount;
    }

    @Override
    public float getCost() {
        return this.productTypes.getCost()  * this.quantity;
    }
}
