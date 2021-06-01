package foodchain.party.farmer;

import foodchain.product.Product;
import foodchain.product.Products.MeatProduct;
import foodchain.product.Products.MeatProducts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FarmerTest {
    @Test
    void create() {
        //Arranged
        Farmer farmer = new Farmer("Bob", 0, 20);

        int expectedQuantity = 2;
        MeatProducts expectedProductTypes = MeatProducts.BEEF;
        //Act
        Product product = farmer.create(2, MeatProducts.BEEF);
        //Assert
        Assertions.assertEquals(expectedProductTypes, product.getProductType().getProductTypes());
        Assertions.assertEquals(expectedQuantity, product.getProductType().getQuantity());
    }
}