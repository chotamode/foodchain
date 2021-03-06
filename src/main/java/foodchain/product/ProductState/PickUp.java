package foodchain.product.ProductState;

import foodchain.product.Product;

/**
 * The type Pick up.
 */
public class PickUp extends ProductState {
    /**
     * Instantiates a new Pick up.
     *
     * @param product the product
     */
    public PickUp(Product product) {
        super(product);
    }

    @Override
    public void setDelivering() {
        System.out.println(product.toString() + "is ready to pick-Up!");
    }

    @Override
    public void setMade() {
        System.out.println(product.toString() + "is ready to pick-Up!");
    }

    @Override
    public void setProcessing() {
        System.out.println(product.toString() + "is ready to pick-Up!");
    }

    @Override
    public void setSold() {
        product.setProductState(new SoldState(product));
    }

    @Override
    public void setStored() {
        System.out.println(product.toString() + "is ready to pick-Up!");
    }

    @Override
    public void setPickUp() {
        System.out.println(product.toString() + "is ready to pick-Up!");
    }
}
