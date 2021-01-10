package foodchain.product.Products;

/**
 * The type Milk product.
 */
public class MilkProduct extends ProductType{

    public MilkProduct(float Liters, MilkProducts milkProducts){
        super(Liters, milkProducts);
    }


    public ProductTypes getProductTypes() {
        return this.productTypes;
    }

    public float getQuantity() {
        return this.quantity;
    }
}
