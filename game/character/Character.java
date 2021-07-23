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

    private int shield;
    private int maxHp;
    private int hp;
    private int mana;
    private int ac;
    private Equipment equipment;
    private Inventory inventory;

    private ArrayList<Effect> effectedBy;
    private CharacterAttributes attributes;

    private Combat combatantAt;
    private DataEnhancement de;
    //private List <Weapon> weapons;

    public Character(String name, int maxHp, int ac){
        this.attributes = new CharacterAttributes(10,10,10,10,10,10); 

        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;        
        this.ac = ac;
        this.equipment = new Equipment(this);
        this.inventory = new Inventory(10, 25 + (this.getModifier("STR") * 3));

        this.equipment.setEquip(new Weapon("Punch", "T", "Fists", "STR", 1, 1));
        System.out.println("Personagem criado! Seu nome eh " + this.name + ", possui "+ this.hp+" pontos de vida e "+ this.ac +" de armadura." + this.equipment.getWielding().getName());
        //this.weapons = new ArrayList<Weapon>();
        this.de = new DataEnhancement();
        System.out.println("Carregando atualmente " + this.inventory.getMaxWeight() + " de peso com " + this.inventory.getMaxSlots() + " tipos de item diferentes. ");
    }
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
    public boolean attack(Character target){
        System.out.println(this.name + " atacou com a " + this.equipment.getWielding().getName()+ ".");
        return this.getWielding().attack(this, target);
    }
    public boolean receiveAttack(int hit, int damage){
        if(this.ac > hit){
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
    public boolean doTurn(Combat combat){
        System.out.println("Oque deseja fazer " + this.getName() + "?");

        System.out.println("1 - Atacar.");
        System.out.println("2 - Mover.");
        System.out.println("3 - Fugir.");

        System.out.print("Resposta: ");
        int choice = Integer.parseInt(this.de.scanf());
        switch (choice) {
            case 1:
                ArrayList<Character> potentialTargets = new ArrayList<Character>();
                System.out.println("---- Possiveis alvos ----");
                for(int counter = 0; counter < combat.getCombatantsNumber(); counter++){
                    if(this == combat.getCombatants().get(counter)) continue;
                    potentialTargets.add(combat.getCombatants().get(counter));
                }
                for(int counter = 0; counter < potentialTargets.size(); counter++){
                    System.out.println(counter+1 +" - "+ potentialTargets.get(counter).getName());
                }

                int target = -1;
                while(target >= potentialTargets.size() || target < 0){
                    System.out.println("Quem deseja quer atacar? ");
                    System.out.print("Resposta: ");
                    target = Integer.parseInt(this.de.scanf()) - 1;
                }
                
                potentialTargets.get(target);
                this.attack(potentialTargets.get(target));
                break;
        
            default:
                System.out.println("Ainda não implementado!");
                break;
        }
        //turnedTurns
        return true;
    }

    public void setDead(){
        this.combatantAt.removeFromCombat(this);
    }
    public void takeDamage(int dmg){
        this.changeHp(-dmg);
    }
    public void changeHp(int value){
        this.hp += value;
        if(this.hp > this.maxHp) this.hp = this.maxHp;
        else if(this.hp <= 0) this.setDead();
    }
    public void setCombatantAt(Combat combatantAt) {
        this.combatantAt = combatantAt;
    }
    //Getters
    public Combat getCombatantAt() {
        return this.combatantAt;
    }
    public int getModifier(Weapon weapon){
        return this.attributes.getAttribute(weapon.getMainAttribute().getShortName()).getMod() + 2;//this.isProficient(obj.getMainAttribute().getShortName());
    }
    public int getModifier(String attributeShortName){
        return this.attributes.getAttribute(attributeShortName).getMod();
    }
    public int getHp() {
        return this.hp;
    }
    public String getName() {
        return name;
    }
    public Weapon getWielding(){
        return this.equipment.getWielding();
    }
    public boolean addInvetory(Item item){
        return this.inventory.put(item);
    }
    public boolean addInvetory(Item item, boolean forced){        
        if(forced) return this.inventory.putForced(item);
        else return this.addInvetory(item);
    }
}


class DataEnhancement{
    // Import the Scanner class
    private Scanner scan;

    DataEnhancement(){
        this.scan = new Scanner(System.in);
    }

    public String scanf(){
        return this.scan.nextLine();
    }
}