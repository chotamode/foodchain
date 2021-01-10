package foodchain.party;

import foodchain.channels.ProductChannel;
import foodchain.channels.util.Request;
import foodchain.party.farmer.Farmer;
import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.transactions.TransactionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    @Test
    void processRequest() {
        ProductChannel productChannel = new ProductChannel(TransactionType.PRODUCT);
        Party customer = new Customer("Sam", 10000);
        Party sellerMacro = new Seller("MACRO.Inc", 900, 70);
        Party sellerTesco = new Seller("TESCO.Inc", 900, 70);
        Party distributor1 = new Distributor("Taxi", 0, 20);
        Party processor = new Processor("CeskaPosta", 0, 15);
        Party storageMakro1 = new Storage("MakroStorage1", 500, 10);
        Party storageMakro2 = new Storage("MakroStorage2", 500, 10);
        Party storageTesco1 = new Storage("TescoStorage1", 500, 10);
        Party storageTesco2 = new Storage("TescoStorage2", 500, 10);
        Party farmer = new Farmer("Bob", 0, 20);

        productChannel.attach(customer);
        productChannel.attach(sellerMacro);
        productChannel.attach(sellerTesco);
        productChannel.attach(distributor1);
        productChannel.attach(processor);
        productChannel.attach(storageMakro1);
        productChannel.attach(storageMakro2);
        productChannel.attach(storageTesco1);
        productChannel.attach(storageTesco2);
        productChannel.attach(farmer);

        productChannel.addRequest(new Request(customer, new MeatProduct(2, MeatProducts.BEEF), PartyType.SELLER));
//        sellerMacro.products.add(new Product(new MeatProduct(1, MeatProducts.BEEF)));

        //+++++++++++++++++++++++++++++++++++

        sellerMacro.fulfillRequest(sellerMacro.requests.element());

        //+++++++++++++++++++++++++++++++++++

        storageMakro1.fulfillRequest(storageMakro1.requests.element());

        //+++++++++++++++++++++++++++++++++++

        farmer.fulfillRequest(farmer.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        distributor1.fulfillRequest(distributor1.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        storageMakro1.processRequest(storageMakro1.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        distributor1.fulfillRequest(distributor1.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        sellerMacro.fulfillRequest(sellerMacro.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        distributor1.fulfillRequest(distributor1.requests.remove());

        //+++++++++++++++++++++++++++++++++++
        System.out.println("\nHo ho, the end!");
    }
}