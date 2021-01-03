package foodchain.channels;

import java.util.ArrayList;

public class ProductChannel implements PartyObservable {
    private ArrayList<String> request = new ArrayList<String>();

    public ProductChannel(){
    }

    public void notifyAllParties() {

    }
}
