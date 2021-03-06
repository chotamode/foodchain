package foodchain.product.ProductState;

import foodchain.product.Product;

/**
 * The type Processing state.
 */
public class ProcessingState extends ProductState {

    /**
     * Instantiates a new Processing state.
     *
     * @param product the product
     */
    public ProcessingState(Product product) {
        super(product);
    }

    @Override
    public void setDelivering() {
        product.setProductState(new DeliveringState(product));
    }

    @Override
    public void setMade() {
        System.out.println(product.toString() + " already made");
    }

    @Override
    public void setProcessing() {
        System.out.println(product.toString() + " already processing");
    }

    @Override
    public void setSold() {
        System.out.println("You should deliver first");
    }

    @Override
    public void setStored() {
        System.out.println("You should deliver first");
    }

    @Override
    public void setPickUp() {
        System.out.println("You should deliver first");
    }
}
