package foodchain.party;

import foodchain.channels.ProductChannel;
import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.transactions.TransactionType;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class DistributorTest {

    @Test
    void processRequest() {
        ProductChannel productChannel = new ProductChannel(TransactionType.PRODUCT);
        Party seller = new Seller("Bob", 900, 70);
        Party customer = new Customer("Ass", 10000);
        Party distributor = new Distributor("Taxi", 0, 20);

        productChannel.attach(seller);
        productChannel.attach(customer);
        productChannel.attach(distributor);

        productChannel.addRequest(new Request(customer, new MeatProduct(2, MeatProducts.BEEF), PartyType.SELLER));
        seller.products.add(new Product(new MeatProduct(10, MeatProducts.BEEF)));
        seller.fulfillRequest(new Request(customer, new MeatProduct(2, MeatProducts.BEEF), PartyType.SELLER));

        Request request1 = distributor.requests.remove();
        distributor.requests.clear();

        distributor.processRequest(request1);
        System.out.println("Hoho, the end!");
    }
}