package foodchain.product.Products;

/**
 * The type Meat product.
 */
public class MeatProduct implements ProductType{
    private final MeatProducts meatProducts;
    private float Kg;

    /**
     * Instantiates a new Meat product.
     *
     * @param Kg           the kg
     * @param meatProducts the meat products
     */
    public MeatProduct(float Kg, MeatProducts meatProducts){
        this.Kg = Kg;
        this.meatProducts = meatProducts;
    }

    public ProductTypes getProduct() {
        return meatProducts;
    }

    public float getQuantity() {
        return Kg;
    }

    @Override
    public void reduce(float amount) {
        this.Kg = Kg - amount;
    }
}
