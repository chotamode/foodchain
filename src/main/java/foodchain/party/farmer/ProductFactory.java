package foodchain.party.farmer;

import foodchain.product.Product;
import foodchain.product.Products.*;

/**
 * The type Product factory.
 */
public abstract class ProductFactory {
    /**
     * Factory method product to make products.
     *
     * @param quantity     the quantity
     * @param productTypes the product types
     * @return the product
     */
    public abstract Product factoryMethod(float quantity, ProductTypes productTypes);
}
