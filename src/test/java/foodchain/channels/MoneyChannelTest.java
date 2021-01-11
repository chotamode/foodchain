package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.party.Customer;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;
import org.junit.jupiter.api.Test;

class MoneyChannelTest {

    @Test
    void addPayment() {
        Customer customer1 = new Customer("Bob", 200);
        Customer customer2 = new Customer("Ass", 300);
        MoneyChannel moneyChannel = new MoneyChannel(TransactionType.MONEY);
        moneyChannel.attach(customer1);
        moneyChannel.attach(customer2);
        System.out.println(customer1.getBalance() + " " + customer2.getBalance());
        moneyChannel.addPaymentTransaction(new Payment(customer1, customer2, 100));
        System.out.println(customer1.getBalance() + " " + customer2.getBalance());
        moneyChannel.addPaymentTransaction(new Payment(customer1, customer2, 100));
        System.out.println(customer1.getBalance() + " " + customer2.getBalance());
        moneyChannel.addPaymentTransaction(new Payment(customer1, customer2, 100));
        System.out.println(customer1.getBalance() + " " + customer2.getBalance());
        Transaction t = customer1.getLastTransactionMoney();
        while (t != null) {
            System.out.println(t);
            t = t.getPreviousTransaction();
        }
    }
}