package foodchain.party.farmer;

import foodchain.party.Party;
import foodchain.product.Product;
import foodchain.product.Products.MeatProducts;
import foodchain.product.Products.ProductTypes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarmerTest {

    @Test
    void create() {
        Farmer farmer = new Farmer("Bob", 0, 20);
        Product product = farmer.create(2, MeatProducts.BEEF);
        System.out.println("hohoohohoh");
    }
}