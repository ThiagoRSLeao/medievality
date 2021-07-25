package game.character;

import java.util.ArrayList;
import java.util.Scanner;


import game.property.Effect;
import game.character.Equipment;
import game.item.type.Item;
import game.item.Inventory;
import game.item.equipment.ArmorPiece;
import game.item.equipment.Jewelry;
import game.item.equipment.Weapon;
import game.mechanics.Combat;

public class Character{ //abstract class Character

    private String name;
    private CharacterClass charClass;

    private Stats baseStats;
    private ClassStats classStats;
    private ArrayList<Stats> effectedBy;

    private ActualStats maxStats;
    private ActualStats trueStats;

    private Equipment equipment;
    private Inventory inventory;    
    private CharacterAttributes attributes;

    private Combat combatantAt;
    //private List <Weapon> weapons;

    public Character(String name, CharacterClass cc){
        this.baseStats = new Stats();
        this.attributes = new CharacterAttributes(); 
        this.charClass = cc;
        this.charClass.setClassStats(this.classStats);

        this.allStats = new ArrayList<Stats>();


        this.name = name;

        this.equipment = new Equipment(this);
        this.inventory = new Inventory(10, 25 + (this.getModifier("STR") * 3));

        this.equipment.setEquip(new Weapon("Punch", "T", "Fists", "STR", 1, 1));
        System.out.println("Personagem criado! Seu nome eh " + this.name + ", possui "+ this.hp+" pontos de vida e "+ this.ac +" de armadura." + this.equipment.getWielding().getName());
        //this.weapons = new ArrayList<Weapon>();
        System.out.println("Carregando atualmente " + this.inventory.getMaxWeight() + " de peso com " + this.inventory.getMaxSlots() + " tipos de item diferentes. ");
    }

    public Character(String name, int[] atts ){
        this.attributes = new CharacterAttributes(atts); 

        this.name = name;

        this.equipment = new Equipment(this);
        this.inventory = new Inventory(10, 25 + (this.getModifier("STR") * 3));


        this.equipment.setEquip(new Weapon("Punch", "T", "Fists", "STR", 1, 1));
        System.out.println("Personagem criado! Seu nome eh " + this.name + ", possui "+ this.hp+" pontos de vida e "+ this.ac +" de armadura." + this.equipment.getWielding().getName());
        //this.weapons = new ArrayList<Weapon>();
        System.out.println("Capacidade de carga é " + this.inventory.getMaxWeight() + " de peso com " + this.inventory.getMaxSlots() + " tipos de item diferentes. ");
    }

    public String getName() {
        return name;
    }

    //HP
    public void setDead(){
        this.combatantAt.removeFromCombat(this);
    }
    public void takeDamage(int dmg){
        this.changeHp(-dmg);
    }
    public void changeHp(int value){
        this.baseStats.hp += value;
        if(this.actualStats.hp > this.getMaxHp()) this.actualStats.hp = this.getMaxHp();
        else if(this.actualStats.hp <= 0) this.setDead();
    }

    //Combat
    public Combat getCombatantAt() {
        return this.combatantAt;
    }
    public void setCombatantAt(Combat combatantAt) {
        this.combatantAt = combatantAt;
    }
    public boolean receiveAttack(int hit, int damage){
        if(this.baseStats.ac > hit){
            System.out.println(this.name + " defendeu o golpe (Acerto: " + hit + ", Armadura: "+this.ac+")");
            return false;
        }
        else{
            this.takeDamage(damage);
            System.out.println(this.name + " foi acertado pelo golpe! (Acerto: " + hit + ", Dano: " + damage + ", Hp atual: " + this.hp + ")");
            return true;
        }
    }
    public boolean receiveAttack(int damage){
        this.takeDamage(damage);
        return true;
    }
    
    //Attributes
    public void setAttribute(String attributeShort,int val){
        this.attributes.setAttribute(attributeShort, val);
    }
    public int getModifier(Weapon weapon){
        return this.attributes.getAttribute(weapon.getMainAttribute().getShortName()).getMod() + 2;//this.isProficient(obj.getMainAttribute().getShortName());
    }
    public int getModifier(String attributeShortName){
        return this.attributes.getAttribute(attributeShortName).getMod();
    }

    //Equipment
    public boolean setEquip(Weapon w)
    {
        return this.equipment.setEquip(w);
    }
    public boolean setEquip(ArmorPiece a)
    {
        return this.equipment.setEquip(a);
    }
    public boolean setEquip(Jewelry j)
    {
        return this.equipment.setEquip(j);
    }    
    public Weapon getWielding(){
        return this.equipment.getWielding();
    }
    
    //Inventory
    public boolean addInvetory(Item item){
        return this.inventory.put(item);
    }
    public boolean addInvetory(Item item, boolean forced){        
        if(forced) return this.inventory.putForced(item);
        else return this.addInvetory(item);
    }

    //Actions
    public boolean attack(Character target){
        System.out.println(this.name + " atacou com a " + this.equipment.getWielding().getName()+ ".");
        return this.getWielding().attack(this, target);
    }    

    //Stats    
    public int getMaxHp() {
        return this.actualStats.hp;
    }
    public int getHp() {
        return this.actualStats.hp;
    }
    //Class
    public void setCharClass(CharacterClass cc){
        this.charClass = cc;
        this.charClass.setClassStats(this.classStats);
    }
}
