package foodchain.product;

import foodchain.product.ParametersStrategy.MeatParametersStrategy;
import foodchain.product.ParametersStrategy.MilkParametersStrategy;
import foodchain.product.ParametersStrategy.ParametersStrategy;
import foodchain.product.ParametersStrategy.PlantParametersStrategy;
import foodchain.product.ProductState.ProductState;
import foodchain.product.Products.*;

import java.util.UUID;


/**
 * The type Product.
 */
public class Product {

    private final ProductType productType;
    private final UUID uuid = UUID.randomUUID();
    public ParametersStrategy parametersStrategy = null;
    private ProductState productState;
    private int expirationDate;
    private int storageTemperature;
    private int storageHumidity;

    /**
     * Instantiates a new Product.
     *
     * @param productType the product type
     */
    public Product(ProductType productType) {
        this.productType = productType;
    }

    /**
     * DO NOT USE OUTSIDE
     * Set product parameters.
     * Used just in process request in Processer
     */
    public void setProductParameters(){
        switch (this.productType.getClass().getName()) {
            case "foodchain.product.Products.MeatProduct" -> setParametersStrategy(new MeatParametersStrategy(this));
            case "foodchain.product.Products.MilkProduct" -> setParametersStrategy(new MilkParametersStrategy(this));
            case "foodchain.product.Products.PlantProduct" -> setParametersStrategy(new PlantParametersStrategy(this));
        }
    }


    /**
     * Splits product.
     *
     * @param amount the amount
     * @return the product
     */
    public Product split(float amount) {
        if (this.getProductType().getQuantity() < amount) {
            System.out.println("Not enough product");
            return null;
        }
        ProductType newProductType = switch (this.productType.getClass().getName()) {
            case "foodchain.product.Products.MeatProduct" -> new MeatProduct(this.productType.getQuantity(), (MeatProducts) this.productType.getProductTypes());
            case "foodchain.product.Products.MilkProduct" -> new MilkProduct(this.productType.getQuantity(), (MilkProducts) this.productType.getProductTypes());
            case "foodchain.product.Products.PlantProduct" -> new PlantProduct(this.productType.getQuantity(), (PlantProducts) this.productType.getProductTypes());
            default -> null;
        };

        Product product = new Product(newProductType);
        if(this.getParametersStrategy() != null){
            product.setProductParameters();
        }
        product.productType.reduce(this.productType.getQuantity() - amount);
        this.productType.reduce(amount);
        return product;
    }

    /**
     * Gets parameters strategy.
     *
     * @return the parameters strategy
     */
    public ParametersStrategy getParametersStrategy() {
        return parametersStrategy;
    }

    /**
     * Sets parameters strategy.
     *
     * @param parametersStrategy the parameters strategy
     */
    public void setParametersStrategy(ParametersStrategy parametersStrategy) {
        this.parametersStrategy = parametersStrategy;
        this.parametersStrategy.setStorageParametersStrategy(this);
    }

    /**
     * Gets product state.
     *
     * @return the product state
     */
    public ProductState getProductState() {
        return productState;
    }

    /**
     * Sets product state.
     *
     * @param state the state
     */
    public void setProductState(ProductState state) {
        this.productState = state;
    }

    /**
     * Gets product type.
     *
     * @return the product type
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    public int getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets expiration date.
     *
     * @param expirationDate the expiration date
     */
    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets storage temperature.
     *
     * @return the storage temperature
     */
    public int getStorageTemperature() {
        return storageTemperature;
    }

    /**
     * Sets storage temperature.
     *
     * @param storageTemperature the storage temperature
     */
    public void setStorageTemperature(int storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    /**
     * Gets storage humidity.
     *
     * @return the storage humidity
     */
    public int getStorageHumidity() {
        return storageHumidity;
    }

    /**
     * Sets storage humidity.
     *
     * @param storageHumidity the storage humidity
     */
    public void setStorageHumidity(int storageHumidity) {
        this.storageHumidity = storageHumidity;
    }
}
