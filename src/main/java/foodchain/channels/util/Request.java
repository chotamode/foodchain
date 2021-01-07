package foodchain.channels.util;

import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Product;

import java.util.UUID;

public class Request implements RP{


    private final UUID id;
    private final Product product;
    private final float amount;
    private PartyType type;
    private Party reciever;
    private final Party customer;/* person who made request*/

    public Party getCustomer() {
        return customer;
    }

    public Party getReciever() {
        return reciever;
    }

    public void setReciever(Party reciever) {
        this.reciever = reciever;
    }

    public boolean isCompleted() {
        return completed;
    }

    public PartyType getType() {
        return type;
    }

    public void setType(PartyType type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public float getAmount() {
        return amount;
    }

    public Request(Product product, float amount, PartyType type, Party reciever, Party customer) {
        this.customer = customer;
        this.reciever = reciever;
        this.type = type;
        this.id = UUID.randomUUID();
        this.product = product;
        this.amount = amount;
    }

    public void setCompleted() {
        this.completed = true;
    }

    private boolean completed = false;
}
