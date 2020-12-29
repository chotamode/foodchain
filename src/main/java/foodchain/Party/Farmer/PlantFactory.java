package foodchain.Party.Farmer;

import foodchain.Product.Product;
import foodchain.Product.Products.PlantProduct;
import foodchain.Product.Products.PlantProducts;
import foodchain.Product.Products.ProductTypes;

public class PlantFactory extends ProductFactory{

    public Product factoryMethod(float quantity, ProductTypes productTypes) {
        return new Product(new PlantProduct(quantity, (PlantProducts) productTypes));
    }
}
