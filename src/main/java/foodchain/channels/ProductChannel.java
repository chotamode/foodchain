package foodchain.channels;

import foodchain.Reporter;
import foodchain.channels.util.DeliveryRequest;
import foodchain.channels.util.Request;
import foodchain.party.*;
import foodchain.party.farmer.Farmer;
import foodchain.product.Product;
import foodchain.product.ProductState.*;
import foodchain.product.Products.ProductType;
import foodchain.transactions.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Product channel.
 */
public class ProductChannel extends Channel {

    List<Request> requests = new LinkedList<>();
    Reporter reporter = Reporter.getReporter();

    /**
     * Instantiates a new Product channel.
     *
     * @param type the type
     */
    public ProductChannel(TransactionType type) {
        super(type);
        this.subscribers = new LinkedList<>();
    }

    @Override
    public void notifyAllParties(Request request) {
        for (ChannelObserver s : subscribers
        ) {
            s.update(request);
        }
    }

    /**
     * Add request and notify all parties about this request.
     *
     * @param request the request
     */
    public void addRequest(Request request) {
        notifyAllParties(request);
        this.requests.add(request);
    }

    /**
     * Add Distribution Transaction to the linked list of
     * transactions (each transaction has field previous transaction).
     *
     * @param creator     the creator
     * @param receiver    the receiver
     * @param distributor the distributor
     * @param product     the product
     */
    public void addDistributionTransaction(Party creator, Party receiver, Party distributor, Product product) {
        if (distributor.getPartyType() != PartyType.DISTRIBUTOR) {
            System.out.println("You have to be " + PartyType.DISTRIBUTOR);
            return;
        }
        product.setProductState((new DeliveringState(product)));

        if (receiver instanceof Customer) {
            product.getProductState().setSold();
        } else if (receiver instanceof Seller) {
            product.getProductState().setPickUp();
        } else if (receiver instanceof Processor) {
            product.getProductState().setProcessing();
        } else if (receiver instanceof Storage) {
            product.getProductState().setStored();
        } else if (receiver instanceof Farmer) {
            product.getProductState().setMade();
        }
        reporter.addFoodChainReport(product.getProductType().getProductTypes() + ": Delivering");

        receiver.addTypeofTransaction(creator);

        lastTransaction = new DistributionTransaction(creator, receiver, distributor, product, lastTransaction);
        notifyAllParties(lastTransaction, subscribers);

        System.out.println("Added: Distribution Transaction");
    }

    /**
     * Add Process Transaction to the linked list of
     * transactions (each transaction has field previous transaction).
     *
     * @param creator the creator
     * @param product the product
     */
    public void addProcessTransaction(Party creator, Product product) {
        if (creator.getPartyType() != PartyType.STORAGE) {
            System.out.println("You have to be " + PartyType.STORAGE);
            return;
        }
        product.setProductState(new ProcessingState(product));
        product.getProductState().setDelivering();

        reporter.addFoodChainReport(product.getProductType().getProductTypes() + ": Processing");

        lastTransaction = new ProcessTransaction(creator, product, lastTransaction);
        notifyAllParties(lastTransaction, subscribers);

        System.out.println("Added: Process Transaction Transaction");
    }

    /**
     * Add Sell Transaction to the linked list of
     * transactions (each transaction has field previous transaction).
     *
     * @param creator     the creator
     * @param receiver    the receiver
     * @param product     the product
     * @param productType the product type
     */
    public void addSellTransaction(Party creator, Party receiver, Product product, ProductType productType) {
        if (creator.getPartyType() == PartyType.DISTRIBUTOR && creator.getPartyType() == PartyType.CUSTOMER) {
            System.out.println("You are not allowed to sell");
            return;
        }
        TransactionIterator transactionIterator = new TransactionIterator(lastTransaction);

        while (transactionIterator.getTransaction().getPreviousTransaction() != null) {
            if (transactionIterator.getTransaction().getTransactionType() == TransactionType.SELL) {
                if (((SellTransaction) transactionIterator.getTransaction()).getUuid() == product.getUuid()) {
                    System.out.println("Double-spending detected from: " + (transactionIterator.getTransaction()).getCreator() + "to: "
                            + ((SellTransaction) transactionIterator.getTransaction()).getReceiver());
                    if (doubleSpending.containsKey(creator)) {
                        for (Map.Entry<Party, Integer> entry : doubleSpending.entrySet()
                        ) {
                            if (entry.getKey() == creator) {
                                entry.setValue(entry.getValue() + 1);
                            }
                        }
                    } else {
                        doubleSpending.put(creator, 1);
                    }
                    reporter.addSecurityReport("Double-spending detected from: " + (transactionIterator.getTransaction()).getCreator() + "to: "
                            + ((SellTransaction) transactionIterator.getTransaction()).getReceiver() + ": " + doubleSpending.get(creator) + " times");
                    return;
                }
            }
            transactionIterator.next();
        }
        product.setProductState(new SoldState(product));
        product.getProductState().setDelivering();

        reporter.addFoodChainReport(product.getProductType().getProductTypes() + ": SOLD");

        lastTransaction = new SellTransaction(creator, receiver, product, productType, lastTransaction);
        notifyAllParties(lastTransaction, subscribers);

        Request request = new DeliveryRequest(creator, receiver, productType, PartyType.DISTRIBUTOR);
        addRequest(request);
        System.out.println("Added: Sell Transaction");
    }

    /**
     * Add Store Transaction to the linked list of
     * transactions (each transaction has field previous transaction).
     *
     * @param creator the creator
     * @param product the product
     */
    public void addStoreTransaction(Party creator, Product product) {
        if (creator.getPartyType() != PartyType.FARMER) {
            System.out.println("You have to be " + PartyType.FARMER);
            return;
        }
        product.setProductState(new StoredState(product));
        product.getProductState().setDelivering();

        reporter.addFoodChainReport(product.getProductType().getProductTypes() + ": Stored");

        lastTransaction = new StoreTransaction(creator, product, lastTransaction);
        notifyAllParties(lastTransaction, subscribers);

        System.out.println("Added: Store Transaction");
    }

    /**
     * Add Create Transaction to the linked list of
     * transactions (each transaction has field previous transaction).
     *
     * @param creator the creator
     * @param product the product
     */
    public void addCreateTransaction(Party creator, Product product) {
        if (creator.getPartyType() != PartyType.FARMER) {
            System.out.println("You have to be " + PartyType.FARMER);
            return;
        }
        product.setProductState(new MadeState(product));
        product.getProductState().setDelivering();

        reporter.addFoodChainReport(product.getProductType().getProductTypes() + ": Created");

        lastTransaction = new CreateProductTransaction(creator, product, lastTransaction);
        notifyAllParties(lastTransaction, subscribers);

        System.out.println("Added: Create Transaction");
    }
}
