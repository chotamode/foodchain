package foodchain.product.ProductState;

import foodchain.product.Product;

public abstract class ProductState {
    Product product;

    ProductState(Product product){
        this.product = product;
    }


}
