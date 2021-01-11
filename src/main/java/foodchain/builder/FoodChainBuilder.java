package foodchain.builder;

import foodchain.party.Party;

import java.util.ArrayList;
import java.util.List;

public class FoodChainBuilder {
    private List<PartyBuilder> builders = new ArrayList<>();

    FoodChainBuilder(String config) {
        switch (config) {
            case "A":
                initA();
                break;
            case "B":
                initB();
                break;
        }
    }

    List<Party> createSystem() {
        List<Party> all = new ArrayList<>();
        for (PartyBuilder builder : builders) {
            all.add(builder.createParty());
        }
        return all;
    }

    private void initA() {
        builders.add(new FarmerBuilder("Bob", 0, 20));
        builders.add(new ProcessorBuilder("CeskaPosta", 500, 15));
        builders.add(new StorageBuilder("MakroStorage1", 500, 10));
        builders.add(new DistributorBuilder("Taxi", 0, 20));
        builders.add(new SellerBuilder("MACRO.Inc", 900, 70));
        builders.add(new CustomerBuilder("Sam", 10000));
    }

    private void initB() {
        builders.add(new FarmerBuilder("Bob", 0, 20));
        builders.add(new ProcessorBuilder("CeskaPosta", 500, 15));
        builders.add(new StorageBuilder("MakroStorage1", 500, 10));
        builders.add(new DistributorBuilder("Taxi", 0, 20));
        builders.add(new SellerBuilder("MACRO.Inc", 900, 70));
        builders.add(new CustomerBuilder("Sam", 10000));
    }

}
