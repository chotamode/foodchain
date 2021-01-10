package foodchain.party;

import foodchain.channels.MoneyChannel;
import foodchain.channels.util.DeliveryRequest;
import foodchain.channels.util.Payment;
import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.transactions.MoneyTransaction;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;

import java.util.Map;

public class Distributor extends Party{

    public Distributor(String name, int balance, int margin) {
        super(name, balance, margin);
    }

    @Override
    protected void requestPayment(Request request){
        if(request.getRespondingDistributor()!= this){
            System.out.println("You are not delivering this product.");
            return;
        }
        System.out.println("Requesting payment");
        if (moneyChannel == null) {
            moneyChannel = new MoneyChannel(TransactionType.MONEY);
        }
        moneyChannel.attach(request.getCreator());
        moneyChannel.attach(request.getRespondingParty());
        moneyChannel.attach(this);
        moneyChannel.addPaymentTransaction(new Payment(request.getCreator(),
                this,
                request.getDeliveryCost()));
        request.setPaid();
    }

    @Override
    protected boolean requestPaid(Request request) {
        for (Map.Entry<Transaction, Boolean> entry : blocks.entrySet()
        ) {
            if (entry.getKey().getTransactionType() == TransactionType.MONEY
                    && request.getRespondingDistributor() == ((MoneyTransaction) entry.getKey()).getReciever()
                    && request.getRespondingDistributor() == this
                    && request.getCost() == ((MoneyTransaction) entry.getKey()).getMoney()
                    && !entry.getValue()) {
                entry.setValue(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public PartyType getPartyType() {
        return PartyType.DISTRIBUTOR;
    }

    @Override
    public void processRequest(Request request){
        request.setRespondingDistributor(this);
        request.setRespondingParty(this);
        requestPayment(request);
        if(!requestPaid(request)){
            System.out.println("Request is not paid.");
            return;
        }

        request.getCreator().giveProduct(this, request.getProductType());

        if(!productAvailable(request)){
            System.out.println(this.getName() + " don't have enough " + request.getProductType().getProductTypes());
        }

        productChannel.addDistributionTransaction(request.getCreator(),
                ((DeliveryRequest)request).getReceiver(),
                this, currentProduct);
        deliverProduct(((DeliveryRequest) request).getReceiver());
    }

    private void deliverProduct(Party receiver){
        receiver.receiveProduct(currentProduct);
        products.clear();
    }
}
