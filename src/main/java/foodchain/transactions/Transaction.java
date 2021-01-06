package foodchain.transactions;

import foodchain.party.Party;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Class-template for transactions in simulation.
 */
public abstract class  Transaction{

    private final Party receiver;
    private final Party sender;
    private final String timestamp;
    private final String hashCode;
    private final String previousHashCode;
    private boolean successful;
    private final Transaction previousTransaction;


    /**
     * Constructs transaction between parties.
     * @param receiver the party which receives money/product.
     * @param sender the party which sends money/product.
     */
    public Transaction(Party receiver, Party sender, Transaction previousTransaction) {
        this.receiver = receiver;
        this.sender = sender;
        this.timestamp = generateTimestamp();

        this.previousTransaction = previousTransaction;
        this.previousHashCode = this.previousTransaction.getHashCode();

        if(receiver == null || sender == null){
            this.hashCode = generateHashCode("genesis", "block");
        }else{
            this.hashCode = generateHashCode(receiver.getPartyType().toString(), sender.getPartyType().toString());
        }

    }

    /**
     * Generates hash code for transaction.
     * @param receiverName the party receiver party of transaction.
     * @param senderName the sender party of transaction.
     * @return hash code of transaction.
     */
    private String generateHashCode(String receiverName, String senderName) {
        String localHashCode = receiverName + senderName + new Random(1000).toString();
        return Integer.toString(localHashCode.hashCode());
    }

    /**
     * Generates timestamp of transaction.
     * @return string generated timestamp of transaction.
     */
    private String generateTimestamp() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(currentDate);
    }

    /**
     * Get hashcode of transaction.
     * @return string generated hash code.
     */
    public String getHashCode() {
        return hashCode;
    }

    /**
     * Get timestamp of transaction.
     * @return string generated timestamp.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Get sender of transaction.
     * @return sender.
     */
    public Party getSender() {
        return sender;
    }

    /**
     * Get receiver of transaction.
     * @return receiver.
     */
    public Party getReceiver() {
        return receiver;
    }

    /**
     * Get a success flag on transaction.
     * @return true if transaction was successful.
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * Get a success flag on transaction.
     * @param successful success flag.
     */
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

//    /**
//     * Link previous transaction in list of transactions.
//     * @param previousTransaction the previous committed transaction in chain.
//     */
//    private void setPreviousTransaction(Transaction previousTransaction) {
//        this.previousTransaction = previousTransaction;
//        try {
//            this.previousHashCode = previousTransaction.getHashCode();
//        } catch (NullPointerException e) {
//            this.previousHashCode = null;
//        }
//    }

    public Transaction getPreviousTransaction() {
        return previousTransaction;
    }

    /**
     * Get transaction flag of current transaction (MONEY / PRODUCT).
     * @return enum type of transaction.
     */
    public abstract TransactionType getTransactionType();
}
