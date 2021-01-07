package foodchain.product.Products;

/**
 * The enum Meat products.
 */
public enum MeatProducts implements ProductTypes{

    BEEF(100),
    PORK(60),
    CHICKEN(40);

    private final int cost;

    MeatProducts(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
