package foodchain.channels.util;

import foodchain.Reporter;
import foodchain.party.Distributor;
import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Products.ProductType;

public class Request {

    private final ProductType productType;
    private final PartyType partyType;//party that can fulfill this request
    private final Party creator;
    Reporter reporter = Reporter.getReporter();
    private Party respondingParty;
    private Distributor respondingDistributor;
    private boolean paid = false;

    public Request(Party creator, ProductType productType, PartyType partyType) {
        this.creator = creator;
        this.partyType = partyType;
        this.productType = productType;
        this.respondingParty = null;
    }

    public Distributor getRespondingDistributor() {
        return respondingDistributor;
    }

    public void setRespondingDistributor(Distributor respondingDistributor) {
        if (this.respondingDistributor == null) {
            this.respondingDistributor = respondingDistributor;
        } else {
            System.out.println("Someone already delivering this request");
        }
    }

    public Party getRespondingParty() {
        return respondingParty;
    }

    public void setRespondingParty(Party respondingParty) {
        this.respondingParty = respondingParty;
    }

    public void setPaid() {
        this.paid = true;
    }


    public boolean isPaid() {
        return paid;
    }

    public float getDeliveryCost() {
        return productType.getCost() * ((float) 1 + (respondingDistributor.getMargin() / (float) 100));
    }

    public float getCost() {
        return productType.getCost() * ((float) 1 + ((float) respondingParty.getMargin() / (float) 100));
    }

    public ProductType getProductType() {
        return productType;
    }

    public PartyType getPartyType() {
        return partyType;
    }

    public float getAmount() {
        return productType.getQuantity();
    }

    public Party getCreator() {
        return creator;
    }

}
