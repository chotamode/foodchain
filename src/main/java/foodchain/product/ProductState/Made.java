package foodchain.product.ProductState;

import foodchain.product.Product;

/**
 * The type Made.
 */
public class Made extends ProductState {

    /**
     * Instantiates a new Made.
     */
    public Made(){
        state = "Made";
    }

    public void setState(Product product) {
        product.setProductState(state);
        System.out.println("The product is made!");
    }
}
