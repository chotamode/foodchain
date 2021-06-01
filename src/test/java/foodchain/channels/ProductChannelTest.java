package foodchain.channels;

import foodchain.channels.util.Request;
import foodchain.party.Customer;
import foodchain.party.Party;
import foodchain.party.PartyType;
import foodchain.party.Seller;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.transactions.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductChannelTest {

    @Test
    void addRequest_requestToChannel_requestInChannelAndSeller() {
        //Arrange
        ProductChannel channel = new ProductChannel(TransactionType.PRODUCT);
        Party seller = new Seller("Captain Amerika", 250, 30);
        Party customer = new Customer("Iron Man", 300);
        Request request = new Request(customer, new MeatProduct(5, MeatProducts.BEEF), PartyType.SELLER);

        //Act
        channel.attach(seller);
        channel.attach(customer);
        channel.addRequest(request);

        //Assert
        Assertions.assertTrue(channel.requests.contains(request));
        Assertions.assertTrue(seller.requests.contains(request));
    }
}