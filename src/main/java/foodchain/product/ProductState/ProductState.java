package foodchain.product.ProductState;

import foodchain.product.Product;

import javax.print.attribute.standard.PrinterMessageFromOperator;


public abstract class ProductState {

    protected Product product;

    public ProductState(Product product) {
        product.setProductState(this);
    }

    abstract void setDelivering();
    abstract void setMade();
    abstract void setProcessing();
    abstract void setSold();
    abstract void setStored();
}
