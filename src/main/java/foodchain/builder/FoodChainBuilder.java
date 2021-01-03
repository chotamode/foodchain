package foodchain.builder;

//import foodchain.channels.ProductChannel;
import foodchain.product.Products.MeatProducts;
import foodchain.product.Products.MilkProducts;
import foodchain.product.Products.PlantProducts;


import java.util.Scanner;

public class FoodChainBuilder {
    public static void main(String[] args){
//        ProductChannel channel = new ProductChannel();
        Scanner sc = new Scanner(System.in);

        MeatProducts[] meatProducts = MeatProducts.values();
        PlantProducts[] plantProducts = PlantProducts.values();
        MilkProducts[] milkProducts = MilkProducts.values();
        for(MeatProducts meat: meatProducts){
            System.out.println(meat);
        }
        System.out.println();
        for(PlantProducts plant: plantProducts){
            System.out.println(plant);
        }
        System.out.println();
        for(MilkProducts milk: milkProducts){
            System.out.println(milk);
        }
        System.out.println();

        //---------------------First-Scenario---------------------------

    }
}
