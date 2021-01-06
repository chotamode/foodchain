package foodchain.product;

import foodchain.party.Party;
import foodchain.product.ParametersStrategy.MeatParametersStrategy;
import foodchain.product.ParametersStrategy.MilkParametersStrategy;
import foodchain.product.ParametersStrategy.ParametersStrategy;
import foodchain.product.ParametersStrategy.PlantParametersStrategy;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.PlantProduct;
import foodchain.product.Products.ProductType;
import foodchain.product.Products.ProductTypes;

/**
 * The type Product.
 */
public class Product {
    /**
     * The Parameters strategy.
     */
    public ParametersStrategy parametersStrategy = null;
    /**
     * The Product state.
     */
    private String productState;

    private int expirationDate;
    private int storageTemperature;
    private int storageHumidity;

    private Party location;
    private final ProductType productType;

    /**
     * Instantiates a new Product.
     *
     * @param productType the product type
     */
    public Product(ProductType productType){
        this.productType = productType;
        if(this.productType.getClass().getName().equals("MeatProduct")){
            setParametersStrategy(new MeatParametersStrategy(this));
        }else if(this.productType.getClass().getName().equals("MilkProduct")){
            setParametersStrategy(new MilkParametersStrategy(this));
        }else if(this.productType.getClass().getName().equals("PlantProduct")){
            setParametersStrategy(new PlantParametersStrategy(this));
        }

    }
//    public Product(){
//
//    }

    /**
     * Sets storage humidity.
     *
     * @param storageHumidity the storage humidity
     */
    public void setStorageHumidity(int storageHumidity) {
        this.storageHumidity = storageHumidity;
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
     * Changes location of the product.
     *
     * @param product the product
     * @param to      Current location
     */
    public void changeLocation(Product product, Party to) {
        //TO IMPLEMENT
    }

    /**
     * Sets parameters strategy.
     *
     * @param parametersStrategy the parameters strategy
     */
    public void setParametersStrategy(ParametersStrategy parametersStrategy){
        this.parametersStrategy = parametersStrategy;
        this.parametersStrategy.setStorageParametersStrategy(this);
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
     * Set product state.
     *
     * @param state the state
     */
    public void setProductState(String state){
        this.productState = state;
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
     * Gets product state.
     *
     * @return the product state
     */
    public String getProductState() {
        return productState;
    }

    /**
     * Gets product type.
     *
     * @return the product type
     */
    public ProductType getProductType() {
        return productType;
    }
}
