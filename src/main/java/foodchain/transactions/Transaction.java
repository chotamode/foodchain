package foodchain.transactions;

import foodchain.party.Party;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class-template for transactions in simulation.
 */
public abstract class Transaction {

    private final Party creator;
    private final String timestamp;
    private final int hashCode;
    private final int previousHashCode;
    private final Transaction previousTransaction;

    public Transaction(Party creator, Transaction previousTransaction) {
        this.creator = creator;
        this.timestamp = generateTimestamp();
        this.previousTransaction = previousTransaction;
        this.hashCode = this.hashCode();
        if (previousTransaction == null && this instanceof GenesisTransaction) {
            this.previousHashCode = -1;
        } else {
            assert previousTransaction != null;
            this.previousHashCode = previousTransaction.hashCode();
        }
    }

    public int getPreviousHashCode() {
        return previousHashCode;
    }

    public Party getCreator() {
        return creator;
    }

    @Override
    public int hashCode() {
        if (previousTransaction == null || creator == null) {
            return super.hashCode();
        }
        return creator.hashCode() * previousTransaction.hashCode();
    }

    private String generateTimestamp() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(currentDate);
    }

    public int getHashCode() {
        return hashCode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Transaction getPreviousTransaction() {
        return previousTransaction;
    }

    public abstract TransactionType getTransactionType();

    @Override
    public String toString() {
        return "{" +
                "creator = " + creator.getClass().getSimpleName() + ": " + creator.getName() +
                ", timestamp = '" + timestamp + '\'' +
                '}';
    }
}
