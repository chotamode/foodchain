package Transactions;

import Party.Party;
import Product.Product;

public class Transaction {
    private TransactionTypes type;
    private String lastHash;
    private Product product;
    private Party reciever;
    private Party sender;
    private String thisHash;
}
