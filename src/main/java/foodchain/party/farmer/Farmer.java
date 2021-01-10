package foodchain.party.farmer;

import foodchain.channels.util.DeliveryRequest;
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

    Product create(float q, ProductTypes productTypes) {
        if (productTypes instanceof MeatProducts) {
            return meatFactory.factoryMethod(q, productTypes);
        } else if (productTypes instanceof MilkProducts) {
            return milkFactory.factoryMethod(q, productTypes);
        } else return plantFactory.factoryMethod(q, productTypes);
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
