package foodchain.Transactions;

import foodchain.Party.Party;
import foodchain.Product.Product;

import java.util.ArrayList;

public class Transaction {
    private final TransactionTypes type;
    private final String lastHash;
    private final Product product;
    private final Party reciever;
    private final Party sender;
    private final String thisHash;

    public Transaction(TransactionTypes type, String lastHash, Product product, Party reciever, Party sender, String thisHash) {
        this.type = type;
        this.lastHash = lastHash;
        this.product = product;
        this.reciever = reciever;
        this.sender = sender;
        this.thisHash = thisHash;
    }
}
