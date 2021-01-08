package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.channels.util.Request;
import foodchain.party.ChannelObserver;
import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.product.Product;
import foodchain.product.Products.ProductType;
import foodchain.transactions.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * The type Product channel.
 */
public class ProductChannel extends Channel {

    List<Request> requests = new LinkedList<Request>();

    public ProductChannel(TransactionType type) {
        super(type);
        this.subscribers = new LinkedList<ChannelObserver>();
    }

    @Override
    public void notifyAllParties(Request request) {
        for (ChannelObserver s:subscribers
        ) {
            s.update(request);
        }
    }

    public void addRequest(Request request){
        notifyAllParties(request);
        this.requests.add(request);
    }

    /**
     * Add DistributionTransaction
     */
    public void addDistributionTransaction(Party creator, Party receiver,Party distributor, Product product, float amount){
        if(creator.getPartyType() != PartyType.DISTRIBUTOR){
            System.out.println("You have to be " + PartyType.DISTRIBUTOR);
            return;
        }
        lastTransaction = new DistributionTransaction(creator, receiver, distributor, product.getProductType(), lastTransaction);
    }

    /**
     *Add ProcessTransaction
     */
    public void addProcessTransaction(Party creator, Product product){
        if(creator.getPartyType() != PartyType.PROCESSOR){
            System.out.println("You have to be " + PartyType.PROCESSOR);
            return;
        }
        lastTransaction = new ProcessTransaction(creator, product, lastTransaction);
    }

    /**
     *Add SellTransaction
     */
    public void addSellTransaction(Party creator, Party receiver, UUID uuid, ProductType productType){
        if(creator.getPartyType() == PartyType.DISTRIBUTOR && creator.getPartyType() == PartyType.CUSTOMER){
            System.out.println("You are not allowed to sell");
            return;
        }
        TransactionIterator transactionIterator = new TransactionIterator(lastTransaction);
        Transaction t = lastTransaction;
        while(t != null){
            if(t.getTransactionType() == TransactionType.SELL){
                if(((SellTransaction)t).getUuid() == uuid){

                }
            }
        }

        lastTransaction = new SellTransaction(creator, receiver, uuid, productType, lastTransaction);
    }

    /**
     *Add StoreTransaction
     */
    public void addStoreTransaction(Party creator, int days, Product product){
        if(creator.getPartyType() != PartyType.STORAGE){
            System.out.println("You have to be " + PartyType.STORAGE);
            return;
        }
        lastTransaction = new StoreTransaction(creator, days, product, lastTransaction);
    }

    /**
     * Add CreateTransaction
     */
    public void addCreateTransaction(Party creator, Product product){
        if(creator.getPartyType() != PartyType.FARMER){
            System.out.println("You have to be " + PartyType.FARMER);
            return;
        }
        lastTransaction = new CreateProductTransaction(creator, product, lastTransaction);
    }
}
