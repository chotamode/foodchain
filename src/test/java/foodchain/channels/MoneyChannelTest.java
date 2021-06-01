package foodchain.channels;

import foodchain.channels.util.Payment;
import foodchain.party.Customer;
import foodchain.transactions.Transaction;
import foodchain.transactions.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyChannelTest {

    @Test
    void addPayment_Bob200AndClient0_Bob0AndClient200NumOfTransactions3() {
        //Arrange
        Customer bob = new Customer("Bob", 200);
        Customer client = new Customer("Client", 0);
        int expected = 3; // With 2 transactions by 100 each and genesis block
        float expectedMoneyCustomer2 = 200;
        float expectedMoneyCustomer1 = 0;

        //Act
        MoneyChannel moneyChannel = new MoneyChannel(TransactionType.MONEY);
        moneyChannel.attach(bob);
        moneyChannel.attach(client);

//        System.out.println(bob.getBalance() + " " + client.getBalance());
        moneyChannel.addPaymentTransaction(new Payment(bob, client, 100));
//        System.out.println(bob.getBalance() + " " + client.getBalance());
        moneyChannel.addPaymentTransaction(new Payment(bob, client, 100));
//        System.out.println(bob.getBalance() + " " + client.getBalance());
        moneyChannel.addPaymentTransaction(new Payment(bob, client, 100));
//        System.out.println(bob.getBalance() + " " + client.getBalance());

        Transaction t = bob.getLastTransactionMoney();    //The last block of chain
        int counter = 0;
        while (t != null) {
            System.out.println(t + " :: NumOfTransaction: " + (counter+1));
            t = t.getPreviousTransaction();
            counter++;
        }
        //Assert
        Assertions.assertEquals(expected, counter);
        Assertions.assertEquals(expectedMoneyCustomer2, client.getBalance());
        Assertions.assertEquals(expectedMoneyCustomer1, bob.getBalance());
    }
}