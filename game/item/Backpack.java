package game.item;

import java.util.ArrayList;
import java.util.Scanner;

import game.item.type.Item;

import game.item.type.EquipableItem;
import game.item.attachable.*;

public class Backpack extends EquipableItem{
    private Inventory inventory;    
    private AttachSockets lanternSockets;
    private AttachSockets trinketSockets;
    private AttachSockets extraSockets;

    public Backpack(){
        this.name = "Bag";
        this.inventory = new Inventory();
        this.lanternSockets = new AttachSockets(0);
        this.trinketSockets = new AttachSockets(0);
        this.extraSockets = new AttachSockets(0);
    }
    public Backpack(String name, Inventory inventory, int ls, int ts, int es){//ArrayList<BackpackSocket> sockets
        this.name = name;
        this.inventory = inventory;
        this.lanternSockets = new AttachSockets(ls);
        this.trinketSockets = new AttachSockets(ts);
        this.extraSockets = new AttachSockets(es);
    }
    public boolean attach(Lantern lantern){        
        return this.lanternSockets.putFreeSocket(lantern);
    }
    public boolean attach(Trinket trinket){        
        return this.trinketSockets.putFreeSocket(trinket);
    }
    public boolean attach(Extra extra){        
        return this.extraSockets.putFreeSocket(extra);
    }
    public boolean put(Item item){
        return this.inventory.put(item);
    }
    public String getName() {
        return name;
    }
    public int getLanternSocketsNum() {
        return lanternSockets.getNumberSockets();
    }
    public int getTrinketSocketsNum() {
        return trinketSockets.getNumberSockets();
    }
    public int getExtraSocketsNum() {
        return extraSockets.getNumberSockets();
    }

    public double getMaxWeight(){
        return this.inventory.getMaxWeight();
    }
    public int getMaxSlots(){
        return this.inventory.getMaxSlots();
    }
    public double getUsedWeight(){
        return this.inventory.getUsedWeight();
    }
    public int getUsedSlots(){
        return this.inventory.getUsedSlots();
    }
    public ArrayList<Item> getItems() {
        return this.inventory.getItems();
    }
}
