package foodchain.product.ProductState;

import foodchain.product.Product;

/**
 * The type Expired.
 */
public class Expired extends ProductState {

    /**
     * Instantiates a new Expired.
     */
    public Expired(){
        state = "Expired";
    }

    /**
     * Changes state of the product.
     *
     * @param product the product
     */
    public void setState(Product product) {
        product.setProductState(state);
        System.out.println("Product has Expired");
    }
}
