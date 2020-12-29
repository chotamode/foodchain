package foodchain.Product;

import foodchain.Party.Party;
import foodchain.Product.ParametersStrategy.ParametersStrategy;
import foodchain.Product.ProductState.ProductState;
import foodchain.Product.Products.MeatProduct;
import foodchain.Product.Products.MeatProducts;
import foodchain.Product.Products.ProductType;

public class Product {
    public ParametersStrategy parametersStrategy = null;
    public ProductState productState = null;
    private int expirationDate;
    private Party location;
    private ProductType productType;

    public Product(ProductType productType){
        this.productType = productType;
    }

    private void changeLocation(Product product, Party to) {

    }


    private void setParametersStrategy(ParametersStrategy parametersStrategy){}

    private void setProductState(ProductState productState){}
}
