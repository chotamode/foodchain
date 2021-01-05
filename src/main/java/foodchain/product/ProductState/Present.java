package foodchain.product.ProductState;

import foodchain.product.Product;

/**
 * The type Present.
 */
public class Present extends ProductState {

    /**
     * Instantiates a new Present.
     */
    public Present(){
        state = "Present";
    }
    public void setState(Product product) {
        product.setProductState(state);
        System.out.println("The product is available(Present)");
    }
}
