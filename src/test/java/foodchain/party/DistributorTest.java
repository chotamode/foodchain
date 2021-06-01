package foodchain.party;

import foodchain.channels.ProductChannel;
import foodchain.channels.util.Request;
import foodchain.party.farmer.ProductFactory;
import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import foodchain.product.Products.ProductTypes;
import foodchain.transactions.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

class DistributorTest {

    @Test
    void processRequest() {
        //Arrange
        ProductChannel productChannel = new ProductChannel(TransactionType.PRODUCT);
        Party seller = new Seller("Bob", 900, 70);
        Party customer = new Customer("Client", 10000);
        Party distributor = new Distributor("Taxi", 0, 20);
        ProductFactory mockedMeatFactory= Mockito.mock(ProductFactory.class);
        //Mock
        Mockito.when(mockedMeatFactory.factoryMethod(ArgumentMatchers.anyFloat(), ArgumentMatchers.any(MeatProducts.class))).
                thenReturn(new Product(new MeatProduct(10, MeatProducts.BEEF)));

        int expectedAmount = 2;
        ProductTypes expectedType = MeatProducts.BEEF;

        //Act
        productChannel.attach(seller);
        productChannel.attach(customer);
        productChannel.attach(distributor);

        productChannel.addRequest(new Request(customer, new MeatProduct(2, MeatProducts.BEEF), PartyType.SELLER));
        seller.products.add(mockedMeatFactory.factoryMethod(10, MeatProducts.BEEF));
        seller.fulfillRequest(new Request(customer, new MeatProduct(2, MeatProducts.BEEF), PartyType.SELLER));

        Request request1 = distributor.requests.remove();
        distributor.requests.clear();

        distributor.processRequest(request1);

        //Assert
        Assertions.assertEquals(expectedAmount, customer.products.get(0).getProductType().getQuantity());
        Assertions.assertEquals(expectedType, customer.products.get(0).getProductType().getProductTypes());
    }
}