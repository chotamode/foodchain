package foodchain.party.farmer;

import foodchain.product.Product;
import foodchain.product.Products.PlantProduct;
import foodchain.product.Products.PlantProducts;
import foodchain.product.Products.ProductTypes;

/**
 * The type Plant factory.
 */
public class PlantFactory extends ProductFactory{

    public Product factoryMethod(float quantity, ProductTypes productTypes) {
        return new Product(new PlantProduct(quantity, (PlantProducts) productTypes));
    }
}
