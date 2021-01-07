package foodchain.product.Products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeatProductsTest {

    @Test
    void values() {
        MeatProducts meatProducts = MeatProducts.BEEF;
        System.out.println(meatProducts.values());
    }

}