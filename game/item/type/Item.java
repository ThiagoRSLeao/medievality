
package game.item.type;

public abstract class Item{
    protected String name;
    protected int maxStack;
    protected double weight;
    protected int takesUpSlots;
    public Item(){
        this.name = "";
        this.maxStack = 1;
        this.weight = 1;
        this.takesUpSlots = 1;
    }
    public int getMaxStack() {
        return maxStack;
    }
    public String getName() {
        return name;
    }
    public int getTakesUpSlots() {
        return takesUpSlots;
    }
    public double getWeight() {
        return weight;
    }
}