package foodchain.transactions;

import foodchain.party.Party;

/**
 * The type Money transaction.
 */
public class MoneyTransaction extends Transaction {

    private final float money;
    private final Party reciever;
    private final TransactionType type = TransactionType.MONEY;

    /**
     * Instantiates a new Money transaction.
     *
     * @param creator             the creator
     * @param reciever            the reciever
     * @param money               the money
     * @param previousTransaction the previous transaction
     */
    public MoneyTransaction(Party creator, Party reciever, float money, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.money = money;
        this.reciever = reciever;
    }


    /**
     * Gets money.
     *
     * @return the money
     */
    public float getMoney() {
        return money;
    }

    public TransactionType getTransactionType() {
        return TransactionType.MONEY;
    }

    @Override
    public String toString() {
        return "{" +
                "money = " + money +
                ", creator = " + getCreator().getClass().getSimpleName() + ": " + getCreator().getName() +
                ", reciever = " + reciever.getClass().getSimpleName() + ": " + reciever.getName() +
                '}';
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Gets reciever.
     *
     * @return the reciever
     */
    public Party getReciever() {
        return reciever;
    }
}
