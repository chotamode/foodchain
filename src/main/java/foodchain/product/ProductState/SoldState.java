package foodchain.product.ProductState;

import foodchain.product.Product;

/**
 * The type Sold state.
 */
public class SoldState extends ProductState {

    /**
     * Instantiates a new Sold state.
     *
     * @param product the product
     */
    public SoldState(Product product) {
        super(product);
    }

    @Override
    public void setDelivering() {
        System.out.println(product.toString() + " is already delivered!");
    }

    @Override
    public void setMade() {
        System.out.println(product.toString() + " SOLD!");
    }

    @Override
    public void setProcessing() {
        System.out.println(product.toString() + " SOLD!");
    }

    @Override
    public void setSold() {
        if (product.getProductState() instanceof SoldState) {
            System.out.println(product.toString() + " SOLD!");
        } else {
            product.setProductState(new SoldState(product));
        }
    }

    @Override
    public void setStored() {
        System.out.println(product.toString() + " SOLD!");
    }

    @Override
    public void setPickUp() {
        System.out.println(product.toString() + " SOLD!");
    }
}
