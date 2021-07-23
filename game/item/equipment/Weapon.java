package game.item.equipment;

import game.character.Character;
import game.character.Attribute;
import game.mechanics.Dice;
import game.item.type.EquipableItem;

public class Weapon extends EquipableItem{
    private Attribute attribute;
    private Dice diceHit;
    private Dice diceDamage;
    private String type;// O = Offhand, M = Mainhand, T = Twohand, H = Head, C = Chest, A = arms, L = Leggins, R = Rings, N = necklace
    private String name;

    public Weapon(String name, String wield, String Type, String attributeShort, int max, int times){
        this.name = name;
        this.attribute = new Attribute(attributeShort);
        this.diceHit = new Dice(1, 20, 1);
        this.diceDamage = new Dice(1, max, times);
        this.where = wield;
    }
    public Weapon(String name, String wield, String Type, String attributeShort, int max){
        this.name = name;
        this.attribute = new Attribute(attributeShort);
        this.diceHit = new Dice(1, 20, 1);
        this.diceDamage = new Dice(1, max, 1);
        this.where = wield;
    }
    public boolean attack(Character wielder, Character target){    
        return target.receiveAttack(this.diceHit.roll(wielder.getModifier(this)), this.diceDamage.roll(wielder.getModifier(this.attribute.getShortName())));
    }
    public Attribute getMainAttribute(){
        return this.attribute;
    }
    public String getName() {
        return name;
    }
    public static Weapon forgeSimpleWeapon(int id, String name){
        switch (id) {
            case 1: return new Weapon(name, "M", "dagger", "DEX", 4);
            case 2: return new Weapon(name, "M", "rapier", "DEX", 8);
            case 3: return new Weapon(name, "T", "great_sword", "STR", 6, 2);
            case 4: return new Weapon(name, "T", "axe", "STR", 12);
            case 5: return new Weapon(name, "O", "broquel", "STR", 4);
            default: return new Weapon("Fists", "T", "fists", "STR", 1);
        }        
    }
}