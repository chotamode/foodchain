package foodchain.product.ParametersStrategy;

import foodchain.product.Product;
import foodchain.product.Products.ProductTypes;

/**
 * The type Plant parameters strategy.
 */
public class PlantParametersStrategy implements ParametersStrategy{
    private ProductTypes productType;
    private Float amountOfKg;

    /**
     * Instantiates a new Plant parameters strategy.
     *
     * @param product the product
     */
    public PlantParametersStrategy(Product product) {
        this.amountOfKg = product.getProductType().getQuantity();
        this.productType = product.getProductType().getProduct();
    }

    public ProductTypes getProductType() {
        return productType;
    }

    public float getAmountOfKgOrLiters() {
        return amountOfKg;
    }

    public void setStorageParametersStrategy(Product product) {
        product.setExpirationDate(10);
        product.setStorageTemperature(5);
        product.setStorageHumidity(75);
    }
}
