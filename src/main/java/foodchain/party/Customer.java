package foodchain.party;

import foodchain.channels.Channel;
import foodchain.channels.ProductChannel;
import foodchain.channels.util.Payment;
import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.product.Products.ProductType;
import foodchain.product.Products.ProductTypes;
import foodchain.transactions.ProductTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Customer.
 */
public class Customer extends Party {
    private static final PartyType partyType = PartyType.CUSTOMER;

    /**
     * Instantiates a new Customer.
     *
     * @param name    the name
     * @param balance the balance
     */
    public Customer(String name, int balance) {
        super(name, balance, partyType);
        products = new ArrayList<Product>();
    }



    public void buyProduct(ProductType productType){
        //Request request = new Request(new Product(productType), productType.getQuantity(), PartyType.SELLER);
        ProductChannel channel = new ProductChannel(TransactionType.PRODUCT);
        attach(channel);
        //sendRequest(request, channel);

    }

    /*
    public int getBalance(){
        int b = 0;
        for (Payment p: payments
             ) {
            if(p.getReciever() == this){
                b = b + p.getMoney();
            }else if(p.getSender() == this){
                b = b - p.getMoney();
            }
        }
    }
    */

    @Override
    public void processRequest(Request request) {
        if(request.getReciever() == request.getCustomer() && request.getReciever() == this){
            request.setCompleted();
        }else{
            System.out.println("Request is not fulfilled");
        }
    }
}