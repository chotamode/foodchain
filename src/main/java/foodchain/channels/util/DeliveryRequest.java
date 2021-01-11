package foodchain.channels.util;

import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Products.ProductType;

/**
 * The type Delivery request.
 */
public class DeliveryRequest extends Request {

    private final Party receiver;

    /**
     * Instantiates a new Delivery request.
     *
     * @param creator     the creator
     * @param receiver    the receiver
     * @param productType the product type
     * @param partyType   the party type: who can process request
     */
    public DeliveryRequest(Party creator, Party receiver, ProductType productType, PartyType partyType) {
        super(creator, productType, partyType);
        this.receiver = receiver;
    }

    /**
     * Gets receiver.
     *
     * @return the receiver
     */
    public Party getReceiver() {
        return receiver;
    }
}
