package foodchain.party;

import foodchain.channels.ProductChannel;
import foodchain.channels.util.Request;

/**
 * The type Seller.
 */
public class Seller extends Party {

    public Seller(String name, int balance, int margin) {
        super(name, balance, margin);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.SELLER;
    }

    @Override
    public void processRequest(Request request) {
        if (productAvailable(request)) {
            request.setRespondingParty(this);
            request.getCreator().requestPayment(request);
            if (!requestPaid(request)) {
                System.out.println("Request is not paid.");
                return;
            }
            productChannel.addSellTransaction(this, request.getCreator(), this.currentProduct, request.getProductType());
        } else {
            System.out.println(this.getName() + " don't have enough " + request.getProductType().getProductTypes());
            productChannel.addRequest(new Request(this, request.getProductType(), PartyType.STORAGE));
        }
    }
}
