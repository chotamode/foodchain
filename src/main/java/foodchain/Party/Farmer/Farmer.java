package foodchain.Party.Farmer;

import foodchain.Party.Party;
import foodchain.Product.Product;
import foodchain.Product.Products.*;

public class Farmer extends Party {
    MeatFactory meatFactory = new MeatFactory();
    MilkFactory milkFactory = new MilkFactory();
    PlantFactory plantFactory = new PlantFactory();

    Product create(float q, MilkProducts milkProducts){
        return milkFactory.factoryMethod(q, milkProducts);
    }

    Product create(float q, MeatProducts meatProducts){
        return meatFactory.factoryMethod(q, meatProducts);
    }

    Product create(float q, PlantProducts plantProducts){
        return plantFactory.factoryMethod(q, plantProducts);
    }

    protected Farmer(String name, int balance) {
        super(name, balance);
    }
}
