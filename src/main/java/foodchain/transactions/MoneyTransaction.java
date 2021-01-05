package foodchain.transactions;

import foodchain.party.Party;

/**
 * The type Money transaction.
 */
public class MoneyTransaction extends Transaction {
    private final int money;

    /**
     * Constructs transaction between parties.
     *
     * @param receiver the party which receives money/product.
     * @param sender   the party which sends money/product.
     * @param money    the money
     */
    public MoneyTransaction(Party receiver, Party sender, int money) {
        super(receiver, sender);
        this.money = money;
    }

    /**
     * Gets money.
     *
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    public TransactionType getTransactionType() {
        return TransactionType.MONEY;
    }
}
