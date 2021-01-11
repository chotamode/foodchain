package foodchain.party;

import foodchain.Reporter;
import foodchain.channels.util.DeliveryRequest;
import foodchain.channels.util.Request;

/**
 * The type Processor.
 */
public class Processor extends Party {
    Reporter reporter = Reporter.getReporter();

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
        reporter.addPartiesReport("Processor: " + this.getName() + " answered on request");
        if (productAvailable(request)) {
            this.currentProduct.setProductParameters();
            reporter.addFoodChainReport("Processor: " + this.getName() + " set product parameters!");
            reporter.addFoodChainReport(this.getClass().getSimpleName() + ": " + this.name);
            reporter.addPartiesReport("Processor: " + this.getName() + " has product now and he is preparing it for delivery");
            request.setRespondingParty(this);
            request.getCreator().requestPayment(request);
            if (!requestPaid(request)) {
                System.out.println("Request is not paid.");
                return;
            }

            Request nextRequest = new DeliveryRequest(this, request.getCreator(), this.currentProduct.getProductType(), PartyType.DISTRIBUTOR);
            productChannel.addRequest(nextRequest);
        } else {
            reporter.addPartiesReport("Processor: " + this.getName() + " doesn't have enough of " + request.getProductType().getProductTypes());
            System.out.println(this.getName() + " don't have enough " + request.getProductType().getProductTypes());
            productChannel.addRequest(new Request(this, request.getProductType(), PartyType.FARMER));
        }
    }
}
