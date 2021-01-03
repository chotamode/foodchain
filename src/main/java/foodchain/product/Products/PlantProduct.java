package foodchain.product.Products;

public class PlantProduct implements ProductType{
    private final PlantProducts plant;
    private final float Kg;

    public PlantProduct(float kg, PlantProducts plant) {
        this.plant = plant;
        Kg = kg;
    }

    public PlantProducts getPlant() {
        return plant;
    }

    public float getKg() {
        return Kg;
    }
}
