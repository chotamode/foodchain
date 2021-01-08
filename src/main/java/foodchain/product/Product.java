package foodchain.product;

import foodchain.party.Party;
import foodchain.product.ParametersStrategy.MeatParametersStrategy;
import foodchain.product.ParametersStrategy.MilkParametersStrategy;
import foodchain.product.ParametersStrategy.ParametersStrategy;
import foodchain.product.ParametersStrategy.PlantParametersStrategy;
import foodchain.product.ProductState.ProductState;
import foodchain.product.Products.ProductType;


public class Product {

    public ParametersStrategy parametersStrategy = null;
    private ProductState productState;

    private int expirationDate;
    private int storageTemperature;
    private int storageHumidity;

    private Party location;
    private final ProductType productType;

    public Product(ProductType productType) {
        this.productType = productType;
        if (this.productType.getClass().getName().equals("MeatProduct")) {
            setParametersStrategy(new MeatParametersStrategy(this));
        } else if (this.productType.getClass().getName().equals("MilkProduct")) {
            setParametersStrategy(new MilkParametersStrategy(this));
        } else if (this.productType.getClass().getName().equals("PlantProduct")) {
            setParametersStrategy(new PlantParametersStrategy(this));
        }

    }

    public void reduce(float amount) {
        productType.reduce(amount);
    }

    public void setParametersStrategy(ParametersStrategy parametersStrategy) {
        this.parametersStrategy = parametersStrategy;
        this.parametersStrategy.setStorageParametersStrategy(this);
    }

    public void setProductState(ProductState state) {
        this.productState = state;
    }

    public ParametersStrategy getParametersStrategy() {
        return parametersStrategy;
    }

    public ProductState getProductState() {
        return productState;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setStorageTemperature(int storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    public void setStorageHumidity(int storageHumidity) {
        this.storageHumidity = storageHumidity;
    }
}
