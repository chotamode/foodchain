package foodchain.channels.util;

import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Products.ProductType;

public class DeliveryRequest extends Request {

    private final Party receiver;

    public DeliveryRequest(Party creator, Party receiver, ProductType productType, PartyType partyType) {
        super(creator, productType, partyType);
        this.receiver = receiver;
    }

    public Party getReceiver() {
        return receiver;
    }
}
