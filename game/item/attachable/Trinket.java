package game.item.attachable;

import game.property.Property;
import game.item.type.Attachable;

public class Trinket extends Attachable{
    private Property bonus;
    public Trinket(String name, Property bonus){
        this.name = name;
        this.bonus = bonus;
    }
}