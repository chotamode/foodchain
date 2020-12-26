package foodchain.Product;

import foodchain.Product.ParametersStrategy.ParametersStrategy;
import foodchain.Product.ProductState.ProductState;

public abstract class Product {
    public ParametersStrategy parametersStrategy = null;
    public ProductState productState = null;

    public void setParametersStrategy(ParametersStrategy parametersStrategy){}

    public void setProductState(ProductState productState){}
}
