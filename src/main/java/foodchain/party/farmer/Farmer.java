package foodchain.party.farmer;

import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Product;
import foodchain.product.Products.*;

/**
 * The type Farmer.
 */
public class Farmer extends Party {
    private static final PartyType partyType = PartyType.FARMER;
    /**
     * The Meat factory.
     */
    MeatFactory meatFactory = new MeatFactory();
    /**
     * The Milk factory.
     */
    MilkFactory milkFactory = new MilkFactory();
    /**
     * The Plant factory.
     */
    PlantFactory plantFactory = new PlantFactory();

    /**
     * Create Milk product.
     *
     * @param q            the q
     * @param milkProducts the milk products
     * @return the product
     */
    Product create(float q, MilkProducts milkProducts){
        return milkFactory.factoryMethod(q, milkProducts);
    }

    /**
     * Create Meat product.
     *
     * @param q            the q
     * @param meatProducts the meat products
     * @return the product
     */
    Product create(float q, MeatProducts meatProducts){
        return meatFactory.factoryMethod(q, meatProducts);
    }

    /**
     * Create Plantw product.
     *
     * @param q             the q
     * @param plantProducts the plant products
     * @return the product
     */
    Product create(float q, PlantProducts plantProducts){
        return plantFactory.factoryMethod(q, plantProducts);
    }

    /**
     * Instantiates a new Farmer.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Farmer(String name, int balance) {
        super(name, balance, partyType);
    }

    public void sendProduct(Product product) {

    }
}
