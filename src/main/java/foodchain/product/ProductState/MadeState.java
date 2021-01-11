package foodchain.product.ProductState;

import foodchain.product.Product;

public class MadeState extends ProductState {

    public MadeState(Product product) {
        super(product);
    }

    @Override
    public void setDelivering() {
        product.setProductState(new DeliveringState(product));
    }

    @Override
    public void setMade() {
        System.out.println(product.toString() + " is made!");
    }

    @Override
    public void setProcessing() {
        System.out.println("You should deliver first");
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
