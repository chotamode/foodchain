package foodchain.party.farmer;

import foodchain.channels.util.DeliveryRequest;
import foodchain.channels.util.Request;
import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Product;
import foodchain.product.Products.MeatProducts;
import foodchain.product.Products.MilkProducts;
import foodchain.product.Products.ProductTypes;

/**
 * The type Farmer.
 */
public class Farmer extends Party {
    private static final PartyType partyType = PartyType.FARMER;
    MeatFactory meatFactory = new MeatFactory();
    MilkFactory milkFactory = new MilkFactory();
    PlantFactory plantFactory = new PlantFactory();

    /**
     * Instantiates a new Farmer.
     *
     * @param name    the name
     * @param balance the balance
     * @param margin  the margin
     */
    public Farmer(String name, int balance, int margin) {
        super(name, balance, margin);
    }

    /**
     * Creates product.
     *
     * @param quantity     the quantity(Kg or Litres(float))
     * @param productTypes the product types ("BEEF", "MILK",....)
     * @return the product
     */
    Product create(float quantity, ProductTypes productTypes) {
        if (productTypes instanceof MeatProducts) {
            return meatFactory.factoryMethod(quantity, productTypes);
        } else if (productTypes instanceof MilkProducts) {
            return milkFactory.factoryMethod(quantity, productTypes);
        } else return plantFactory.factoryMethod(quantity, productTypes);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.FARMER;
    }

    @Override
    public void processRequest(Request request) {
        request.setRespondingParty(this);
        request.getCreator().requestPayment(request);
        if (!requestPaid(request)) {
            System.out.println("Request is not paid.");
            return;
        }
        this.currentProduct = create(request.getAmount(), request.getProductType().getProductTypes());
        products.add(currentProduct);
        productChannel.addCreateTransaction(this, currentProduct);
        productChannel.addRequest(new DeliveryRequest(this, request.getCreator(), currentProduct.getProductType(), PartyType.DISTRIBUTOR));
    }
}
