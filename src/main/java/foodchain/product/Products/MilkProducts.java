package foodchain.product.Products;

/**
 * The enum Milk products.
 */
public enum MilkProducts implements ProductTypes {

    MILK(20),
    YOGHURT(40),
    CREAM(60);

    private final int cost;

    MilkProducts(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
