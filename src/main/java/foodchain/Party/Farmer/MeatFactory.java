package foodchain.Party.Farmer;

import foodchain.Product.Product;
import foodchain.Product.Products.MeatProduct;
import foodchain.Product.Products.MeatProducts;
import foodchain.Product.Products.ProductTypes;

public class MeatFactory extends ProductFactory{

    public Product factoryMethod(float quantity, ProductTypes productTypes) {
        return new Product(new MeatProduct(quantity, (MeatProducts) productTypes));
    }
}
