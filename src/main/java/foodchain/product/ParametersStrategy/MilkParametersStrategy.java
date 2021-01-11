package foodchain.product.ParametersStrategy;

import foodchain.product.Product;
import foodchain.product.Products.ProductTypes;

/**
 * The type Milk parameters strategy.
 */
public class MilkParametersStrategy implements ParametersStrategy {
    private ProductTypes productType;

    public MilkParametersStrategy(Product product) {
        this.productType = product.getProductType().getProductTypes();
    }

    public ProductTypes getProductType() {
        return productType;
    }

    public void setStorageParametersStrategy(Product product) {
        product.setExpirationDate(7);
        product.setStorageTemperature(4);
        product.setStorageHumidity(60);
    }

}
