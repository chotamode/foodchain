package foodchain.product.ProductState;

import foodchain.product.Product;

import javax.print.attribute.standard.PrinterMessageFromOperator;


public abstract class ProductState {

    protected static Product product;

    public ProductState(Product product) {
        ProductState.product = product;
        product.setProductState(this);
    }

    public abstract void setDelivering();

    public abstract void setMade();

    public abstract void setProcessing();

    public abstract void setSold();

    public abstract void setStored();

    public abstract void setPickUp();
}
