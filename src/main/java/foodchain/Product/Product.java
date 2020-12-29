package foodchain.Product;

import foodchain.Party.Party;
import foodchain.Product.ParametersStrategy.ParametersStrategy;
import foodchain.Product.ProductState.ProductState;

public class Product {
    public ParametersStrategy parametersStrategy = null;
    public ProductState productState = null;
    private final String name;
    private int expirationDate;
    private Party location;


    protected Product(String name) {
        this.name = name;
    }

    private void changeLocation(Product product, Party to) {

    }


    private void setParametersStrategy(ParametersStrategy parametersStrategy){}

    private void setProductState(ProductState productState){}
}
