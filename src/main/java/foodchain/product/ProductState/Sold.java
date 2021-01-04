package foodchain.product.ProductState;

import foodchain.product.Product;

/**
 * The type Sold.
 */
public class Sold extends ProductState {
    /**
     * Instantiates a new Sold.
     */
    public Sold(){
        state = "Sold";
    }

    public void setState(Product product) {
        product.setProductState(state);
        System.out.println("Product was Sold and almost yours.");
    }
}
