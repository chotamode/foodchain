package foodchain.Party.Farmer;

import foodchain.Product.Product;
import foodchain.Product.Products.*;

public abstract class ProductFactory {
    public abstract Product factoryMethod(float quantity, ProductTypes productTypes);
}
