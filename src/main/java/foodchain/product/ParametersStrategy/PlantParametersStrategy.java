package foodchain.product.ParametersStrategy;

import foodchain.product.Product;
import foodchain.product.Products.ProductTypes;

/**
 * The type Plant parameters strategy.
 */
public class PlantParametersStrategy implements ParametersStrategy {
    private final ProductTypes productType;

    public PlantParametersStrategy(Product product) {
        this.productType = product.getProductType().getProductTypes();
    }

    public ProductTypes getProductType() {
        return productType;
    }

    public void setStorageParametersStrategy(Product product) {
        product.setExpirationDate(10);
        product.setStorageTemperature(5);
        product.setStorageHumidity(75);
    }
}
