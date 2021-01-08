package foodchain.builder;

//import foodchain.channels.ProductChannel;
import foodchain.party.Seller;
import foodchain.party.farmer.Farmer;
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
        SellerBuilder sellerBuilder = new SellerBuilder("Ashot", 1000, 40);
        Seller seller = (Seller) sellerBuilder.createParty();
        FarmerBuilder farmerBuilder = new FarmerBuilder("Brat_Ashota", 500, 0);
        Farmer farmer = (Farmer) farmerBuilder.createParty();


    }
}
