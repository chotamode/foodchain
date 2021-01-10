package foodchain.party;

import foodchain.channels.util.DeliveryRequest;
import foodchain.channels.util.Request;
import foodchain.product.Product;

/**
 * The type Processor.
 */
public class Processor extends Party{

    /**
     * Instantiates a new Processor.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Processor(String name, int balance, int margin) {
        super(name, balance, margin);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.PROCESSOR;
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

            Request nextRequest = new DeliveryRequest(this, request.getCreator(), request.getProductType(), PartyType.DISTRIBUTOR);
            productChannel.addRequest(nextRequest);
//            productChannel.addSellTransaction(this, request.getCreator(), this.currentProduct, request.getProductType());
        } else {
            System.out.println(this.getName() + " don't have enough " + request.getProductType().getProductTypes());
            productChannel.addRequest(new Request(this, request.getProductType(), PartyType.STORAGE));
        }
    }
}
