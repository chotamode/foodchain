package foodchain.product.ProductState;

import foodchain.product.Product;

public class StoredState extends ProductState{

    public StoredState(Product product) {
        super(product);
    }

    @Override
    void setDelivering() {
        product.setProductState(new DeliveringState(product));
    }

    @Override
    void setMade() {
        System.out.println(product.toString() + " already made");
    }

    @Override
    void setProcessing() {
        System.out.println("You should deliver first");
    }

    @Override
    void setSold() {
        System.out.println("You should deliver first");
    }

    @Override
    void setStored() {
        System.out.println("You should deliver first");
    }
}
