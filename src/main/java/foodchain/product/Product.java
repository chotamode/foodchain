package foodchain.product;

import foodchain.party.Party;
import foodchain.product.ParametersStrategy.ParametersStrategy;
import foodchain.product.ProductState.ProductState;
import foodchain.product.Products.ProductType;

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
