package foodchain.builder;

import foodchain.channels.ProductChannel;
import foodchain.party.*;
import foodchain.party.farmer.Farmer;
import foodchain.transactions.TransactionType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Food chain builder.
 */
public class FoodChainBuilder {
    private final List<PartyBuilder> builders = new ArrayList<>();

    /**
     * Instantiates a new Food chain builder.
     *
     * @param config the config
     */
    public FoodChainBuilder(String config) {
        switch (config) {
            case "A" -> initA();
            case "B" -> initB();
        }
    }

    /**
     * Create system: creates list of all parties.
     *
     * @return the list of parties
     */
    public List<Party> createSystem() {
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

    /**
     * Initialize customer and attaches him to the product channel.
     *
     * @param all            the all parties
     * @param productChannel the product channel
     * @return the customer
     */
    public Customer initializeCustomer(List<Party> all, ProductChannel productChannel) {
        for (Party p : all
        ) {
            if (p instanceof Customer) {
                productChannel.attach(p);
                return (Customer) p;
            }
        }
        return null;
    }

    /**
     * Initialize seller and attaches him to the product channel.
     *
     * @param all            the all parties
     * @param productChannel the product channel
     * @return the seller
     */
    public Seller initializeSeller(List<Party> all, ProductChannel productChannel) {
        for (Party p : all
        ) {
            if (p instanceof Seller) {
                productChannel.attach(p);
                return (Seller) p;
            }
        }
        return null;
    }

    /**
     * Initialize distributor and attaches him to the product channel.
     *
     * @param all            the all parties
     * @param productChannel the product channel
     * @return the distributor
     */
    public Distributor initializeDistributor(List<Party> all, ProductChannel productChannel) {
        for (Party p : all
        ) {
            if (p instanceof Distributor) {
                productChannel.attach(p);
                return (Distributor) p;
            }
        }
        return null;
    }

    /**
     * Initialize processor and attaches him to the product channel.
     *
     * @param all            the all parties
     * @param productChannel the product channel
     * @return the processor
     */
    public Processor initializeProcessor(List<Party> all, ProductChannel productChannel) {
        for (Party p : all
        ) {
            if (p instanceof Processor) {
                productChannel.attach(p);
                return (Processor) p;
            }
        }
        return null;
    }

    /**
     * Initialize storage and attaches him to the product channel.
     *
     * @param all            the all parties
     * @param productChannel the product channel
     * @return the storage
     */
    public Storage initializeStorage(List<Party> all, ProductChannel productChannel) {
        for (Party p : all
        ) {
            if (p instanceof Storage) {
                productChannel.attach(p);
                return (Storage) p;
            }
        }
        return null;
    }

    /**
     * Initialize farmer and attaches him to the product channel.
     *
     * @param all            the all parties
     * @param productChannel the product channel
     * @return the farmer
     */
    public Farmer initializeFarmer(List<Party> all, ProductChannel productChannel) {
        for (Party p : all
        ) {
            if (p instanceof Farmer) {
                productChannel.attach(p);
                return (Farmer) p;
            }
        }
        return null;
    }
}
