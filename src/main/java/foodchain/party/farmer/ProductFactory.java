package foodchain.party.farmer;

import foodchain.product.Product;
import foodchain.product.Products.*;

public abstract class ProductFactory {
    public abstract Product factoryMethod(float quantity, ProductTypes productTypes);
}
