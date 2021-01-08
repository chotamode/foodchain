package foodchain.transactions;

import foodchain.party.Party;

public class MoneyTransaction extends Transaction {

    private final float money;
    private final Party reciever;
    private final TransactionType type = TransactionType.MONEY;

    public MoneyTransaction(Party creator, Party reciever, float money, Transaction previousTransaction) {
        super(creator, previousTransaction);
        this.money = money;
        this.reciever = reciever;
    }


    public float getMoney() {
        return money;
    }

    public TransactionType getTransactionType() {
        return TransactionType.MONEY;
    }

    @Override
    public String toString() {
        return "MoneyTransaction{" +
                "money=" + money +
                ", reciever=" + reciever +
                ", creator=" + getCreator() +
                '}';
    }

    public TransactionType getType() {
        return type;
    }

    public Party getReciever() {
        return reciever;
    }
}
