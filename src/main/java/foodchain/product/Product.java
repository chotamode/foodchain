package foodchain.product;

import foodchain.product.ParametersStrategy.MeatParametersStrategy;
import foodchain.product.ParametersStrategy.MilkParametersStrategy;
import foodchain.product.ParametersStrategy.ParametersStrategy;
import foodchain.product.ParametersStrategy.PlantParametersStrategy;
import foodchain.product.ProductState.ProductState;
import foodchain.product.Products.*;

import java.util.UUID;


public class Product {

    private final ProductType productType;
    private final UUID uuid = UUID.randomUUID();
    public ParametersStrategy parametersStrategy = null;
    private ProductState productState;
    private int expirationDate;
    private int storageTemperature;
    private int storageHumidity;

    public Product(ProductType productType) {
        this.productType = productType;
    }

    public void setProductParameters(){
        switch (this.productType.getClass().getName()) {
            case "foodchain.product.Products.MeatProduct" -> setParametersStrategy(new MeatParametersStrategy(this));
            case "foodchain.product.Products.MilkProduct" -> setParametersStrategy(new MilkParametersStrategy(this));
            case "foodchain.product.Products.PlantProduct" -> setParametersStrategy(new PlantParametersStrategy(this));
        }
    }


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

    public ParametersStrategy getParametersStrategy() {
        return parametersStrategy;
    }

    public void setParametersStrategy(ParametersStrategy parametersStrategy) {
        this.parametersStrategy = parametersStrategy;
        this.parametersStrategy.setStorageParametersStrategy(this);
    }

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState state) {
        this.productState = state;
    }

    public ProductType getProductType() {
        return productType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature(int storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    public int getStorageHumidity() {
        return storageHumidity;
    }

    public void setStorageHumidity(int storageHumidity) {
        this.storageHumidity = storageHumidity;
    }
}
