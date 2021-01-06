package foodchain.party;

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
    private Map<Transaction, TransactionType> listOfTransactions;


    /**
     * Instantiates a new Seller.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Seller(String name, int balance) {
        super(name, balance, partyType);
        this.listOfTransactions = new HashMap<Transaction, TransactionType>();
    }


    public void sendProduct(Product product) {
    }
}
