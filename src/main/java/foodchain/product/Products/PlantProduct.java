package foodchain.product.Products;

/**
 * The type Plant product.
 */
public class PlantProduct implements ProductType{
    private final PlantProducts plantProducts;
    private final float Kg;

    /**
     * Instantiates a new Plant product.
     *
     * @param kg    the kg
     * @param plant the plant
     */
    public PlantProduct(float kg, PlantProducts plant) {
        this.plantProducts = plant;
        Kg = kg;
    }

    public ProductTypes getProductTypes() {
        return plantProducts;
    }

    public float getQuantity() {
        return Kg;
    }
}
