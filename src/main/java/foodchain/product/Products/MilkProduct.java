package foodchain.product.Products;

/**
 * The type Milk product.
 */
public class MilkProduct implements ProductType{
    private final MilkProducts milkProducts;
    private final float Liters;

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


    public ProductTypes getProduct() {
        return milkProducts;
    }

    public float getQuantity() {
        return Liters;
    }
}
