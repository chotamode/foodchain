package foodchain.Builder;

import foodchain.Channel;
import foodchain.Product.Products.MeatProducts;
import foodchain.Product.Products.MilkProducts;
import foodchain.Product.Products.PlantProducts;


import java.util.Scanner;

public class FoodChainBuilder {
    public static void main(String[] args){
        Channel channel = new Channel();
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
