package foodchain.Product.Products;

public class MeatProduct implements ProductType{
    private final MeatProducts meatProducts;
    private final float Kg;

    public MeatProduct(float Kg, MeatProducts meatProducts){
        this.Kg = Kg;
        this.meatProducts = meatProducts;
    }

    public MeatProducts getMeatProducts() {
        return meatProducts;
    }

    public float getKg() {
        return Kg;
    }
}
