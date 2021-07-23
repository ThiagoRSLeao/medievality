package game.item;

import java.util.*;

import game.item.type.*;

public class Inventory{
    protected int maxSlots;
    protected int occupiedSlots;
    protected double maxWeight;
    protected double weight;
    protected ArrayList<Item> items;

    public Inventory(){
        this.maxSlots = 15;
        this.occupiedSlots = 0;
        this.maxWeight = 100.0;
        this.weight = 0.0;
        this.items = new ArrayList<Item>();
    }
    public Inventory(int slots, double maxWeight){
        this.maxSlots = slots;
        this.occupiedSlots = 0;
        this.maxWeight = maxWeight;
        this.weight = 0.0;
        this.items = new ArrayList<Item>();
    }
    public double checkWeight() {
        double w = 0.0;
        for(int counter = 0;counter < items.size(); counter++)
        {
            w += items.get(counter).getWeight();
        }
        return w;
    }
    public double getWeight() {
        return weight;
    }
    public double getMaxWeight() {
        return maxWeight;
    }
    public int getMaxSlots() {
        return maxSlots;
    }
    public boolean put(Item item){
        if((this.weight + item.getWeight()) > this.maxWeight || (this.occupiedSlots + item.getTakesUpSlots()) > this.maxSlots)
        {
            return false;
        }
        this.items.add(item);
        this.weight += item.getWeight();
        this.occupiedSlots += item.getTakesUpSlots();
        return true;
    }
    public boolean putForced(Item item){
        this.items.add(item);
        this.weight += item.getWeight();
        this.occupiedSlots += item.getTakesUpSlots();
        return true;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public double getUsedWeight(){
        return this.weight;
    }
    public int getUsedSlots(){
        return this.occupiedSlots;
    }
}
