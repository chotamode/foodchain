package foodchain.channels.util;

import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Products.ProductType;

public class Request {

    private final ProductType productType;
    private final PartyType partyType;//party that can fulfill this request
    private final Party creator;
    private Party responding;
    private boolean paid = false;

    public Request(Party creator, ProductType productType, PartyType partyType) {
        this.creator = creator;
        this.partyType = partyType;
        this.productType = productType;
        this.responding = null;
    }

    public void setResponding(Party responding) {
        if(this.responding == null){
            this.responding = responding;
        }else{
            System.out.println("Someone already fulfilling this request");
        }

    }

    public Party getResponding() {
        return responding;
    }

    public void setPaid() {
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public float getCost(){
        return productType.getQuantity() * productType.getCost() * (1 + (responding.getMargin()/100));
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
