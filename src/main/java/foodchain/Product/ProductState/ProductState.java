package foodchain.Product.ProductState;

import foodchain.Product.Product;

public abstract class ProductState {
    Product product;

    ProductState(Product product){
        this.product = product;
    }


}
