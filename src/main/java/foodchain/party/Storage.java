package foodchain.party;

import foodchain.Reporter;
import foodchain.channels.util.DeliveryRequest;
import foodchain.channels.util.Request;

/**
 * The type Storage.
 */
public class Storage extends Party {
    Reporter reporter = Reporter.getReporter();

    /**
     * Instantiates a new Storage.
     *
     * @param name    the name
     * @param balance the balance
     * @param margin  the margin
     */
    public Storage(String name, int balance, int margin) {
        super(name, balance, margin);
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.STORAGE;
    }

    @Override
    public void processRequest(Request request) {
        reporter.addPartiesReport("Storage: " + this.getName() + " answered on request");
        if (productAvailable(request)) {
            reporter.addFoodChainReport(this.getClass().getSimpleName() + ": " + this.name);
            reporter.addPartiesReport("Storage: " + this.getName() + " has product now and he is preparing it for delivery");
            request.setRespondingParty(this);
            request.getCreator().requestPayment(request);
            if (!requestPaid(request)) {
                System.out.println("Request is not paid.");
                return;
            }

            Request nextRequest = new DeliveryRequest(this, request.getCreator(), this.currentProduct.getProductType(), PartyType.DISTRIBUTOR);
            productChannel.addRequest(nextRequest);
        } else {
            reporter.addPartiesReport("Seller: " + this.getName() + " doesn't have enough of " + request.getProductType().getProductTypes());
            System.out.println(this.getName() + " don't have enough " + request.getProductType().getProductTypes());
            productChannel.addRequest(new Request(this, request.getProductType(), PartyType.PROCESSOR));
        }
    }
}
