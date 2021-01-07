package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyChannelTest {

    @Test
    void addPayment() {
        MoneyChannel moneyChannel = new MoneyChannel(TransactionType.MONEY);
        moneyChannel.addPayment(new Payment(null, null, 100));
        moneyChannel.addPayment(new Payment(null, null, 101));
        moneyChannel.addPayment(new Payment(null, null, 102));
        Transaction t = moneyChannel.lastTransaction;
        while(t != null){
            System.out.println(t);
            t = t.getPreviousTransaction();
        }
    }
}