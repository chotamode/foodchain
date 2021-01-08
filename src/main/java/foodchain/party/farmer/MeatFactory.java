package foodchain.party.farmer;

import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.product.Products.ProductTypes;

/**
 * The type Meat factory.
 */
public class MeatFactory extends ProductFactory{

    public Product factoryMethod(float quantity, ProductTypes productTypes) {
        return new Product( new MeatProduct(quantity, (MeatProducts) productTypes));
    }
}
