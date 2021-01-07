package foodchain.product.Products;

/**
 * The enum Plant products.
 */
public enum PlantProducts implements ProductTypes{

    TOMATOES(5),
    POTATOES(4),
    ONION(1000);

    final int cost;

    PlantProducts(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
