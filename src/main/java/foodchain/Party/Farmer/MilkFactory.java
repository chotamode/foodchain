package foodchain.Party.Farmer;

import foodchain.Product.Product;
import foodchain.Product.Products.MilkProduct;
import foodchain.Product.Products.MilkProducts;
import foodchain.Product.Products.ProductTypes;

public class MilkFactory extends ProductFactory{
    public Product factoryMethod(float quantity, ProductTypes productTypes) {
        return new Product(new MilkProduct(quantity, (MilkProducts) productTypes));
    }
}
