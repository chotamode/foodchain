package foodchain.party;

import foodchain.channels.util.Request;

/**
 * The type Seller.
 */
public class Seller extends Party{

    private static final PartyType partyType = PartyType.SELLER;

    public Seller(String name, int balance, int margin) {
        super(name, balance, margin);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.SELLER;
    }

    @Override
    public void processRequest(Request request) {
        if(productAvailable(request)){
            request.setResponding(this);
            request.getCreator().requestPayment(request);
            sendDeliveryRequest(this, request.getCreator(), request.getProductType());
        }else{
            System.out.println(this.getName() + " don't have enough " + request.getProductType().getProductTypes());
        }
    }

    public int getMargin() {
        return super.getMargin();
    }
}
