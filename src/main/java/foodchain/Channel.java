package foodchain;

import foodchain.ObserverObservable.PartyObservable;

import java.util.ArrayList;

public class Channel implements PartyObservable {
    private ArrayList<String> request = new ArrayList<String>();

    public Channel(){
    }
}
