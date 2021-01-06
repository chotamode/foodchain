package foodchain.channels;

import foodchain.channels.util.Request;
import foodchain.party.Party;
import foodchain.party.Seller;
import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.transactions.TransactionType;

import static org.junit.jupiter.api.Assertions.*;

class ProductChannelTest {

    @org.junit.jupiter.api.Test
    void addRequest() {
        ProductChannel channel = new ProductChannel(TransactionType.PRODUCT);
        Party seller = new Seller("hui", 250);
        channel.attach(seller);
        seller.sendRequest(new Request(new Product(new MeatProduct(20, MeatProducts.BEEF)), 10),channel);
        return;
    }
}