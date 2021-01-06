package foodchain.product.ProductState;

import foodchain.product.Product;

import javax.print.attribute.standard.PrinterMessageFromOperator;

/**
 * The type Product state.
 */
public abstract class ProductState {
    /**
     * The State.
     */
    protected String state;

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param product the product
     */
    public void setState(Product product){
    }
}
