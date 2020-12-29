package foodchain.Product.Products;

public class MilkProduct implements ProductType{
    private final MilkProducts milkProducts;
    private final float Liters;

    public MilkProduct(float Liters, MilkProducts milkProducts){
        this.Liters = Liters;
        this.milkProducts = milkProducts;
}

    public MilkProducts getMilkProducts() {
        return milkProducts;
    }

    public float getLiters() {
        return Liters;
    }
}
