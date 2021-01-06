package foodchain.channels;

import foodchain.channels.util.Request;
import foodchain.party.Customer;
import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.party.Seller;
import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.transactions.TransactionType;

class ProductChannelTest {

    @org.junit.jupiter.api.Test
    void addRequest() {
        ProductChannel channel = new ProductChannel(TransactionType.PRODUCT);
        Party seller = new Seller("hui", 250);
        Party customer = new Customer("ass", 300);
        channel.attach(seller);
        return;
    }
}