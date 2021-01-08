package foodchain.product.ProductState;

import foodchain.product.Product;

public class DeliveringState extends ProductState{

    public DeliveringState(Product product) {
        super(product);
    }

    @Override
    void setDelivering() {
        System.out.println(product.toString() + " is already delivering");
    }

    @Override
    void setMade() {
        System.out.println(product.toString() + " already made");
    }

    @Override
    void setProcessing() {
        product.setProductState(new ProcessingState(product));
    }

    @Override
    void setSold() {
        product.setProductState(new SoldState(product));
    }

    @Override
    void setStored() {
        product.setProductState(new StoredState(product));
    }
}
