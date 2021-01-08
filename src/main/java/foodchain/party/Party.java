package foodchain.party;

import foodchain.channels.Channel;
import foodchain.channels.MoneyChannel;
import foodchain.channels.ProductChannel;
import foodchain.channels.util.DeliveryRequest;
import foodchain.channels.util.Payment;
import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.product.Products.ProductType;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Party implements ChannelObserver {
    private int balance;
    private final String name;
    private List<Product> products;
    private List<Request> requests;
    private MoneyChannel moneyChannel;
    private ProductChannel productChannel;
    private Map<Transaction, Boolean> blocks; //payments transactions, boolean means if money accepted
    private Transaction lastTransactionMoney = null;
    private Transaction lastTransactionProduct = null;
    private final int margin;

    protected Party(String name, int balance, int margin) {
        if(margin > 100){
            margin = margin % 100;
        }
        this.name = name;
        this.balance = balance;
        this.margin = margin;
        this.products = new LinkedList<Product>();
        this.requests = new LinkedList<Request>();
        this.blocks = new HashMap<Transaction, Boolean>();
    }

    protected boolean requestPaid(Request request) {
        for (Map.Entry<Transaction, Boolean> entry : blocks.entrySet()
        ) {
            if (request.getCreator() == ((MoneyTransaction) entry.getKey()).getReciever()
                    && request.getCreator() == this
                    && request.getCost() == ((MoneyTransaction) entry.getKey()).getMoney()
                    && !entry.getValue()) {
                entry.setValue(true);
                return true;
            }
        }
        return false;
    }

    public void fulfillRequest(Request request) {
        if (request.getPartyType() != this.getPartyType()) {
            System.out.println("You can't fulfill this request(wrong party type)");
            return;
        }
        processRequest(request);
    }

    public abstract PartyType getPartyType();

    public abstract void processRequest(Request request);

    protected abstract boolean canProcessRequest(Request request);

    public boolean productAvailable(Request request) {
        for (Product p : products
        ) {
            if (p.getProductType().getProductTypes() == request.getProductType().getProductTypes()
                    && request.getAmount() <= p.getProductType().getQuantity()) {
                return true;
            }
        }
        return false;
    }

    public void sendDeliveryRequest(Party sender, Party receiver, ProductType productType){
        if(this.getPartyType() == PartyType.DISTRIBUTOR){
            System.out.println("Distributor can't create Distribution Request");
            return;
        }
        if (productChannel != null) {
            Request request = new DeliveryRequest(sender, receiver, productType, PartyType.DISTRIBUTOR);
            productChannel.addRequest(request);
        } else {
            System.out.println("You don't subscribed to product channel");
        }
    }

    public void sendRequest(ProductType productType) {
        if(this.balance < productType.getCost()){
            System.out.println("You don't have enough money");
            return;
        }
        if (productChannel != null) {
            Request request = new Request(this, productType, this.getPartyType());
            productChannel.addRequest(request);
        } else {
            System.out.println("You don't subscribed to product channel");
        }
    }

    @Override
    public void attach(Channel channel) {
        if (channel instanceof MoneyChannel) {
            moneyChannel = (MoneyChannel) channel;
        } else {
            productChannel = (ProductChannel) channel;
        }
    }

    @Override
    public void detach(Channel channel) {
        if (channel instanceof MoneyChannel && channel == this.moneyChannel) {
            moneyChannel = null;
        } else if (channel instanceof ProductChannel && channel == this.productChannel) {
            productChannel = null;
        }
    }

    @Override
    public void update(Request request) {
        if(canProcessRequest(request)){
            requests.add(request);
        }
    }

    @Override
    public void update(Transaction transaction) {
        if (transaction.getTransactionType() == TransactionType.MONEY) {
            if (((MoneyTransaction) transaction).getReciever() == this) {
                balance = balance + ((MoneyTransaction) transaction).getMoney();
            } else if (transaction.getCreator() == this) {
                balance = balance - ((MoneyTransaction) transaction).getMoney();
            }
            lastTransactionMoney = transaction;
        } else if (transaction.getTransactionType() != TransactionType.MONEY) {
            lastTransactionProduct = transaction;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Transaction getLastTransactionMoney() {
        return lastTransactionMoney;
    }

    public Transaction getLastTransactionProduct() {
        return lastTransactionProduct;
    }

    public List<Product> getProducts() {
        return products;
    }

    protected void requestPayment(Request request){
        moneyChannel.addPaymentTransaction(new Payment(this,
                request.getResponding(),
                request.getCost()));
        request.setPaid();
    }

    public int getMargin() {
        return margin;
    }
}
