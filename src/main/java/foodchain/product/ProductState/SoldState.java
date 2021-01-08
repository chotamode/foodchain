package foodchain.product.ProductState;

import foodchain.product.Product;

public class SoldState extends ProductState{

    public SoldState(Product product) {
        super(product);
    }

    @Override
    void setDelivering() {
        System.out.println(product.toString() + " SOLD!");
    }

    @Override
    void setMade() {
        System.out.println(product.toString() + " SOLD!");
    }

    @Override
    void setProcessing() {
        System.out.println(product.toString() + " SOLD!");
    }

    @Override
    void setSold() {
        if(product.getProductState() instanceof SoldState){
            System.out.println(product.toString() + " SOLD!");
        }else{
            product.setProductState(new SoldState(product));
        }

    }

    @Override
    void setStored() {
        System.out.println(product.toString() + " SOLD!");
    }
}
