package foodchain.product.Products;

/**
 * The type Milk product.
 */
public class MilkProduct implements ProductType{
    private final MilkProducts milkProducts;
    private float Liters;

    /**
     * Instantiates a new Milk product.
     *
     * @param Liters       the liters
     * @param milkProducts the milk products
     */
    public MilkProduct(float Liters, MilkProducts milkProducts){
        this.Liters = Liters;
        this.milkProducts = milkProducts;
    }


    public ProductTypes getProductTypes() {
        return milkProducts;
    }

    public float getQuantity() {
        return Liters;
    }

    @Override
    public void reduce(float amount) {
        this.Liters = Liters - amount;
    }
}
