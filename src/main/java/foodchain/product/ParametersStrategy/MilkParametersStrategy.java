package foodchain.product.ParametersStrategy;

import foodchain.product.Product;
import foodchain.product.Products.ProductTypes;

/**
 * The type Milk parameters strategy.
 */
public class MilkParametersStrategy implements ParametersStrategy{
    private ProductTypes productType;
    private Float amountOfLiters;

    /**
     * Instantiates a new Milk parameters strategy.
     *
     * @param product the product
     */
    public MilkParametersStrategy(Product product) {
        this.amountOfLiters = product.getProductType().getQuantity();
        this.productType = product.getProductType().getProduct();
    }

    public ProductTypes getProductType() {
        return productType;
    }

    public float getAmountOfKgOrLiters() {
        return amountOfLiters;
    }

    public void setStorageParametersStrategy(Product product) {
        product.setExpirationDate(7);
        product.setStorageTemperature(4);
        product.setStorageHumidity(60);
    }

}
