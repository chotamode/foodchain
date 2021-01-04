package foodchain.product.ParametersStrategy;

import foodchain.product.Product;
import foodchain.product.Products.ProductTypes;

/**
 * The interface Parameters strategy.
 */
public interface ParametersStrategy {

    /**
     * Get product type.
     *
     * @return the product types
     */
    ProductTypes getProductType();

    /**
     * Gets amount of kg.
     *
     * @return the amount of kg
     */
    float getAmountOfKgOrLiters();

    /**
     * Sets storage parameters strategy.
     */
    void setStorageParametersStrategy(Product product);
}
