package foodchain.product.ParametersStrategy;

import foodchain.product.Product;
import foodchain.product.Products.ProductTypes;

/**
 * The type Meat parameters strategy.
 */
public class MeatParametersStrategy implements ParametersStrategy{
    private ProductTypes productType;

    /**
     * Instantiates a new Meat parameters strategy.
     *
     * @param product the product
     */
    public MeatParametersStrategy(Product product) {
        this.productType = product.getProductType().getProductTypes();
    }

    public ProductTypes getProductType() {
        return productType;
    }

    public void setStorageParametersStrategy(Product product) {
        product.setExpirationDate(12);
        product.setStorageTemperature(-1);
        product.setStorageHumidity(85);
    }


}
