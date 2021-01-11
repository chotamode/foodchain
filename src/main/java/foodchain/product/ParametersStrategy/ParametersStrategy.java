package foodchain.product.ParametersStrategy;

import foodchain.product.Product;
import foodchain.product.Products.ProductTypes;

public interface ParametersStrategy {

    ProductTypes getProductType();

    void setStorageParametersStrategy(Product product);
}
