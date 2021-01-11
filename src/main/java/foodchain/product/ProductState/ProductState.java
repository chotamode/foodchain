package foodchain.product.ProductState;

import foodchain.product.Product;

import javax.print.attribute.standard.PrinterMessageFromOperator;


/**
 * The type Product state.
 */
public abstract class ProductState {

    protected static Product product;

    /**
     * Instantiates a new Product state.
     *
     * @param product the product
     */
    public ProductState(Product product) {
        ProductState.product = product;
        product.setProductState(this);
    }

    /**
     * Sets State: delivering.
     */
    public abstract void setDelivering();

    /**
     * Sets State: made.
     */
    public abstract void setMade();

    /**
     * Sets State: processing.
     */
    public abstract void setProcessing();

    /**
     * Sets State: sold.
     */
    public abstract void setSold();

    /**
     * Sets State: stored.
     */
    public abstract void setStored();

    /**
     * Sets State: pick up.
     */
    public abstract void setPickUp();
}
