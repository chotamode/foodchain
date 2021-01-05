package foodchain.party;

import foodchain.ObserverObservable.ChannelObserver;
import foodchain.product.Product;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Party.
 */
public abstract class Party implements ChannelObserver {
    private int balance;
    private final String name;
    private final PartyType partyType;
    private Map<Transaction, TransactionType> listOfTransactions = new HashMap<Transaction, TransactionType>();

    /**
     * Instantiates a new Party.
     *
     * @param name      the name
     * @param balance   the balance
     * @param partyType the party type
     */
    protected Party(String name, int balance, PartyType partyType) {
        this.name = name;
        this.balance = balance;
        this.partyType = partyType;
    }

    public abstract void sendProduct(Product product);

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets party type.
     *
     * @return the party type
     */
    public PartyType getPartyType() {
        return partyType;
    }
}
