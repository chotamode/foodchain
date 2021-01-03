package foodchain.party.farmer;

import foodchain.product.Product;
import foodchain.product.Products.MilkProduct;
import foodchain.product.Products.MilkProducts;
import foodchain.product.Products.ProductTypes;

public class MilkFactory extends ProductFactory{
    public Product factoryMethod(float quantity, ProductTypes productTypes) {
        return new Product(new MilkProduct(quantity, (MilkProducts) productTypes));
    }
}
