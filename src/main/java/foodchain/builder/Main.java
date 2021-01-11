package foodchain.builder;

import foodchain.Reporter;
import foodchain.channels.ProductChannel;
import foodchain.channels.util.Request;
import foodchain.party.*;
import foodchain.party.farmer.Farmer;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.transactions.TransactionType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reporter reporter = Reporter.getReporter();
        ProductChannel productChannel = new ProductChannel(TransactionType.PRODUCT);

        FoodChainBuilder foodChainBuilder = new FoodChainBuilder("A");

        List<Party> all = foodChainBuilder.createSystem();

        Party customer = null;
        Seller sellerMacro = null;
        Party distributor = null;
        Party processor = null;
        Storage storageMakro = null;
        Party farmer = null;
        for (Party p : all
        ) {
            productChannel.attach(p);
            if (p instanceof Customer) {
                customer = p;
            } else if (p instanceof Seller) {
                sellerMacro = (Seller) p;
            } else if (p instanceof Distributor) {
                distributor = p;
            } else if (p instanceof Processor) {
                processor = p;
            } else if (p instanceof Storage) {
                storageMakro = (Storage) p;
            } else if (p instanceof Farmer) {
                farmer = p;
            }
        }

        Seller sellerTesco = new Seller("TESCO.Inc", 900, 70); // FOR DOUBLE-SPENDING PROBLEM

        productChannel.attach(sellerTesco);

        productChannel.addRequest(new Request(customer, new MeatProduct(2, MeatProducts.BEEF), PartyType.SELLER));

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
