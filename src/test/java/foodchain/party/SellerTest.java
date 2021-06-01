package foodchain.party;

import foodchain.channels.ProductChannel;
import foodchain.channels.util.Request;
import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.transactions.TransactionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SellerTest {

    @Test
    void processRequest() {
        ProductChannel productChannel = new ProductChannel(TransactionType.PRODUCT);
        Party seller = new Seller("Bob", 900, 30);
        Party customer = new Customer("Client", 10000);

        productChannel.attach(seller);
        productChannel.attach(customer);

        productChannel.addRequest(new Request(customer, new MeatProduct(5, MeatProducts.BEEF), PartyType.SELLER));
        seller.products.add(new Product(new MeatProduct(10, MeatProducts.BEEF)));
        seller.processRequest(new Request(customer, new MeatProduct(5, MeatProducts.BEEF), PartyType.SELLER));
    }
}