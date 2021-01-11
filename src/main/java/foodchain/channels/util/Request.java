package foodchain.channels.util;

import foodchain.Reporter;
import foodchain.party.Distributor;
import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Products.ProductType;

/**
 * The type Request.
 */
public class Request {

    private final ProductType productType;
    private final PartyType partyType;
    private final Party creator;
    /**
     * The Reporter.
     */
    Reporter reporter = Reporter.getReporter();
    private Party respondingParty;
    private Distributor respondingDistributor;
    private boolean paid = false;

    /**
     * Instantiates a new Request.
     *
     * @param creator     the creator
     * @param productType the product type
     * @param partyType   the party type: party that can fulfill this request
     */
    public Request(Party creator, ProductType productType, PartyType partyType) {
        this.creator = creator;
        this.partyType = partyType;
        this.productType = productType;
        this.respondingParty = null;
    }

    /**
     * Gets responding distributor.
     *
     * @return the responding distributor
     */
    public Distributor getRespondingDistributor() {
        return respondingDistributor;
    }

    /**
     * Sets responding distributor.
     *
     * @param respondingDistributor the responding distributor
     */
    public void setRespondingDistributor(Distributor respondingDistributor) {
        if (this.respondingDistributor == null) {
            this.respondingDistributor = respondingDistributor;
        } else {
            System.out.println("Someone already delivering this request");
        }
    }

    /**
     * Gets responding party.
     *
     * @return the responding party (the current party in charge)
     */
    public Party getRespondingParty() {
        return respondingParty;
    }

    /**
     * Sets responding party.
     *
     * @param respondingParty the responding party (the current party in charge)
     */
    public void setRespondingParty(Party respondingParty) {
        this.respondingParty = respondingParty;
    }


    public void setPaid() {
        this.paid = true;
    }


    /**
     * Is paid boolean.
     *
     * @return the boolean
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Gets delivery cost with counted margin of responding distributor party.
     *
     * @return the delivery cost
     */
    public float getDeliveryCost() {
        return productType.getCost() * ((float) 1 + (respondingDistributor.getMargin() / (float) 100));
    }

    /**
     * Gets cost with counted margin of responding party.
     *
     * @return the cost
     */
    public float getCost() {
        return productType.getCost() * ((float) 1 + ((float) respondingParty.getMargin() / (float) 100));
    }

    /**
     * Gets product type.
     *
     * @return the product type
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Gets party type.
     *
     * @return the party type
     */
    public PartyType getPartyType() {
        return partyType;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public float getAmount() {
        return productType.getQuantity();
    }

    /**
     * Gets creator.
     *
     * @return the creator
     */
    public Party getCreator() {
        return creator;
    }

}
