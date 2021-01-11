package foodchain.product.ProductState;

import foodchain.product.Product;

/**
 * The type Delivering state.
 */
public class DeliveringState extends ProductState {

    /**
     * Instantiates a new Delivering state.
     *
     * @param product the product
     */
    public DeliveringState(Product product) {
        super(product);
    }

    @Override
    public void setDelivering() {
        System.out.println(product.toString() + " is already delivered!");
    }

    @Override
    public void setMade() {
        System.out.println(product.toString() + " already made!");
    }

    @Override
    public void setProcessing() {
        product.setProductState(new ProcessingState(product));
    }

    @Override
    public void setSold() {
        product.setProductState(new SoldState(product));
    }

    @Override
    public void setStored() {
        product.setProductState(new StoredState(product));
    }

    @Override
    public void setPickUp() {
        product.setProductState(new PickUp(product));
    }
}
