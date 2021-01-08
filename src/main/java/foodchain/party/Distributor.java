package foodchain.party;

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
        getMoneyChannel().addPaymentTransaction(new Payment(this,
                request.getRespondingParty(),
                request.getDeliveryCost()));
        request.setPaid();
    }

    @Override
    protected boolean requestPaid(Request request) {
        for (Map.Entry<Transaction, Boolean> entry : blocks.entrySet()
        ) {
            if (request.getRespondingDistributor() == ((MoneyTransaction) entry.getKey()).getReciever()
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
    public void processRequest(Request request) {
        request.setRespondingDistributor(this);
        request.getRespondingParty().requestPayment(request);
        if(!requestPaid(request)){
            System.out.println("Request is not paid.");
            return;
        }
    }

}
