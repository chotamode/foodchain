package foodchain.party.farmer;

import foodchain.channels.util.Request;
import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Product;
import foodchain.product.Products.*;

public class Farmer extends Party {
    private static final PartyType partyType = PartyType.FARMER;
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

    public Farmer(String name, int balance, int margin) {
        super(name, balance, margin);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.FARMER;
    }

    @Override
    public void processRequest(Request request) {

    }

    public void sendProduct(Product product) {

    }
}
