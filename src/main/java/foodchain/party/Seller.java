package foodchain.party;

import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.transactions.ProductTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Seller.
 */
public class Seller extends Party{

    private static final PartyType partyType = PartyType.SELLER;


    /**
     * Instantiates a new Seller.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Seller(String name, int balance) {
        super(name, balance, partyType);
    }


    public void sendProduct(Product product) {
    }

    @Override
    public void processRequest(Request request) {
        if(request.getReciever() == request.getCustomer() && request.getReciever() == this){
            request.setCompleted();
            return;
        }else if()
    }
}
