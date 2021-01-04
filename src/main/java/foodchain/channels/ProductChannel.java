package foodchain.channels;

import java.util.ArrayList;

/**
 * The type Product channel.
 */
public class ProductChannel implements PartyObservable {
    private ArrayList<String> request = new ArrayList<String>();

    /**
     * Instantiates a new Product channel.
     */
    public ProductChannel(){
    }

    public void notifyAllParties() {

    }
}
