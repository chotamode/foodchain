package foodchain.builder;

import foodchain.Reporter;
import foodchain.channels.ProductChannel;
import foodchain.channels.util.Request;
import foodchain.party.*;
import foodchain.party.farmer.Farmer;
import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.transactions.TransactionType;

public class FoodChainBuilder {
    public static void main(String[] args) {
        Reporter reporter = Reporter.getReporter();
        ProductChannel productChannel = new ProductChannel(TransactionType.PRODUCT);

        Party customer = new Customer("Sam", 10000);
        Seller sellerMacro = new Seller("MACRO.Inc", 900, 70);
        Seller sellerTesco = new Seller("TESCO.Inc", 900, 70);
        Party distributor = new Distributor("Taxi", 0, 20);
        Party processor = new Processor("CeskaPosta", 500, 15);
        Storage storageMakro = new Storage("MakroStorage1", 500, 10);
        Party farmer = new Farmer("Bob", 0, 20);

        productChannel.attach(customer);
        productChannel.attach(sellerMacro);

        productChannel.attach(sellerTesco);

        productChannel.attach(distributor);
        productChannel.attach(processor);
        productChannel.attach(storageMakro);
        productChannel.attach(farmer);

        productChannel.addRequest(new Request(customer, new MeatProduct(2, MeatProducts.BEEF), PartyType.SELLER));
//        sellerMacro.products.add(new Product(new MeatProduct(1, MeatProducts.BEEF)));

        //+++++++++++++++++++++++++++++++++++

        sellerMacro.fulfillRequest(sellerMacro.requests.element());

        //+++++++++++++++++++++++++++++++++++

        storageMakro.fulfillRequest(storageMakro.requests.element());

        //+++++++++++++++++++++++++++++++++++

        processor.fulfillRequest(processor.requests.element());

        //+++++++++++++++++++++++++++++++++++

        farmer.fulfillRequest(farmer.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        distributor.fulfillRequest(distributor.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        processor.fulfillRequest(processor.requests.element());

        //+++++++++++++++++++++++++++++++++++

        distributor.fulfillRequest(distributor.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        storageMakro.fulfillRequest(storageMakro.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        distributor.fulfillRequest(distributor.requests.remove());

        //+++++++++++++++++++++++++++++++++++

        sellerTesco.products.add(sellerMacro.products.get(0));

        sellerMacro.fulfillRequest(sellerMacro.requests.remove());


        //+++++++++++++++++++++++++++++++++++

        distributor.fulfillRequest(distributor.requests.remove());

        //++++++++++Discretni_krok_1+++++++++

        productChannel.addRequest(new Request(customer, new MeatProduct(2, MeatProducts.BEEF), PartyType.SELLER));

        //+++++++++++++++++++++++++++++++++++

        sellerTesco.products.get(0).getProductType().addToCounters(2);
        sellerTesco.fulfillRequest(sellerMacro.requests.element());

        //+++++++++++++++++++++++++++++++++++
        reporter.showPartiesReport();
        reporter.showFoodChainReport();
        reporter.showTransactionReport();
        reporter.showPartiesReport();
        reporter.showSecurityReport();
        //+++++++++++++++++++++++++++++++++++
        System.out.println("\nHo ho, the end!");
    }
}
