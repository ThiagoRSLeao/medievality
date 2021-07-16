import java.util.List;
import java.util.Random;
import java.lang.annotation.Target;
import java.util.ArrayList; 
import java.util.Scanner; 
// Java program to illustrate the 
// concept of Association
class Aggregation {
    public static void main(String[] args){
        System.out.println("Iniciando combate!");
        Character player1 = new Character("Hadryk", 15, 15);
        Weapon dagger = Weapon.forgeSimpleWeapon(1, "Black Dagger");
        player1.wieldWeapon(dagger);

        Character player2 = new Character("Kuilan", 10, 18);
        Weapon rapier = Weapon.forgeSimpleWeapon(3, "Gold Rapier");
        player2.wieldWeapon(rapier);

        Character player3 = new Character("Bentinho Chave", 30, 10);
        Weapon axe = Weapon.forgeSimpleWeapon(4, "Linux");
        player3.wieldWeapon(axe);

        Combat c1 = new Combat();
        c1.insertCombat(player1);
        c1.insertCombat(player2);
        c1.insertCombat(player3);
        c1.run();
    }
}


class Rpg{

}

class Dice{
    private int minRaw;
    private int maxRaw;
    private int times;
    private Random rand;

    Dice(int minRaw, int maxRaw, int times){
        this.rand = new Random();
        this.minRaw = minRaw;
        this.maxRaw = maxRaw;
        this.times = times;
    }
    public int roll(int mod){
        if(maxRaw == minRaw) return 1 + mod;
        int roll = rand.nextInt(maxRaw - minRaw) + minRaw + mod;
        for(int c = 1; c < this.times; c++) roll += rand.nextInt(maxRaw - minRaw);
        return roll;
    }
}

class Weapon{
    private Attribute attribute;
    private Dice diceHit;
    private Dice diceDamage;
    private String type;
    private String name;

    Weapon(String name, String Type, String attributeShort, int max, int times){
        this.name = name;
        this.attribute = new Attribute(attributeShort);
        this.diceHit = new Dice(1, 20, 1);
        this.diceDamage = new Dice(1, max, times);
    }
    Weapon(String name, String Type, String attributeShort, int max){
        this.name = name;
        this.attribute = new Attribute(attributeShort);
        this.diceHit = new Dice(1, 20, 1);
        this.diceDamage = new Dice(1, max, 1);
    }
    public boolean atack(Character wielder, Character target){    
        return target.receiveAtack(this.diceHit.roll(wielder.getModifier(this)), this.diceDamage.roll(wielder.getModifier(this.attribute.getShortName())));
    }
    public Attribute getMainAttribute(){
        return this.attribute;
    }
    public String getName() {
        return name;
    }


    public static Weapon forgeSimpleWeapon(int id, String name){
        switch (id) {
            case 1: return new Weapon(name, "dagger", "DEX", 4);
            case 2: return new Weapon(name, "rapier", "DEX", 8);
            case 3: return new Weapon(name, "great_sword", "STR", 6, 2);
            case 4: return new Weapon(name, "axe", "STR", 12);
            default:return new Weapon("Fists", "fists", "STR", 1);
        }        
    }
    /*public int damage(){

    }*/
}

class Character{ //abstract class Character
    private String name;
    private int maxHp;
    private int hp;
    private int ac;
    private Weapon wielding;
    private CharacterAttributes attributes;
    private DataEnhancement de;
    private Combat combatantAt;
    //private List <Weapon> weapons;

    Character(String name, int maxHp, int ac){
        this.de = new DataEnhancement();
        
        this.name = name;
        this.maxHp = maxHp;
        this.hp = this.maxHp;
        this.ac = ac;
        this.wieldWeapon();
        this.attributes = new CharacterAttributes(20,20,20,20,20,20); 
        System.out.println("Personagem criado! Seu nome eh " + this.name + ", possui "+ this.hp+" pontos de vida e "+ this.ac +" de armadura.");
        //this.weapons = new ArrayList<Weapon>();
    }
    public void wieldWeapon(Weapon w){
        this.wielding = w;
    }
    public void wieldWeapon(){
        this.wielding = new Weapon("Punch", "Fists", "STR", 1, 1);
    }
    public boolean atack(Character target){
        System.out.println(this.name + " atacou com a " + this.wielding.getName()+ ".");
        return this.wielding.atack(this, target);
    }
    public boolean receiveAtack(int hit, int damage){
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
    public boolean receiveAtack(int damage){
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
                this.atack(potentialTargets.get(target));
                break;
        
            default:
                System.out.println("Ainda não implementado!");
                break;
        }
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
}
class Attribute{
    String name;
    String shortName;
    int value;
    int mod;
    Attribute(String attributeShort){
        switch (attributeShort) {
            case "STR": this.name = "Strength";      break;
            case "DEX": this.name = "Dexterity";     break;
            case "CON": this.name = "Constitution";  break;
            case "INT": this.name = "Inteligence";   break;
            case "WIS": this.name = "Wisdom";        break;
            case "CHA": this.name = "Charisma";      break;        
            //default:    erro                  break;
        }
        this.shortName = attributeShort;
    }
    Attribute(String attributeShort, int value){
        switch (attributeShort) {
            case "STR": this.name = "Strength";      break;
            case "DEX": this.name = "Dexterity";     break;
            case "CON": this.name = "Constitution";  break;
            case "INT": this.name = "Inteligence";   break;
            case "WIS": this.name = "Wisdom";        break;
            case "CHA": this.name = "Charisma";      break;        
            //default:    erro                  break;
        }
        this.shortName = attributeShort;
        this.value = value;
        this.calcMod();
    }
    void calcMod(){
        int mod = -5;
        int i = this.value;
        while(i > 1){
            mod += 1;
            i = i - 2;
        }
        this.mod = mod;
    }
    public int getMod() {
        return this.mod;
    }
    public String getShortName() {
        return this.shortName;
    }
}
class CharacterAttributes{
    Attribute strength;
    Attribute dexterity;
    Attribute constitution;
    Attribute inteligence;
    Attribute wisdom;
    Attribute charisma;
    Attribute VA;

    CharacterAttributes(int strength, int dexterity, int constitution, int inteligence, int wisdom, int charisma){
        this.strength = new Attribute("STR",strength);
        this.dexterity = new Attribute("DEX",dexterity);
        this.constitution = new Attribute("CON",constitution);
        this.inteligence = new Attribute("INT",inteligence);
        this.wisdom = new Attribute("WIS",wisdom);
        this.charisma = new Attribute("CHA",charisma);
        this.VA = new Attribute("VOID", 0);
    }
    public Attribute getAttribute(String attributeShort){
        switch (attributeShort) {
            case "STR": return this.strength;
            case "DEX": return this.dexterity;          
            case "CON": return this.constitution;   
            case "INT": return this.inteligence;  
            case "WIS": return this.wisdom;       
            case "CHA": return this.charisma;   
            /*default: return NULL;  break;*/
        }
        return this.VA;
    }
}
class Combat{
    ArrayList<Character> combatants;
    int combatantsNumber;
    int actualTurn;
    boolean combatEnds;

    Combat(){
        combatants = new ArrayList<Character>();
        combatantsNumber = 0;
        actualTurn = 0;
    }
    public void run(){        
        while(!this.checkEnd()){
            System.out.println("\n");
            this.assignTurn();
            System.out.println("\n");
        }
        System.out.println("\nFim de combate!");
    }
    public void insertCombat(Character character){
        combatants.add(character);
        character.setCombatantAt(this);
        this.combatantsNumber += 1;
    }
    public void removeFromCombat(Character character){
        combatants.remove(character);
        this.combatantsNumber -= 1;
    }
    public void assignTurn(){
        combatants.get(actualTurn).doTurn(this);//while(!combatants.get(actualTurn).doTurn(this));        
        if(actualTurn < this.combatantsNumber-1) actualTurn += 1;
        else actualTurn = 0;
    }
    public boolean checkEnd(){
        if(this.combatantsNumber > 1){
            return false;
        }
        //else if() cobatants == team, endcombat
        else{
            return true;
        }
    }
    public ArrayList<Character> getCombatants(){
        return this.combatants;
    }
    public Character getCombatant(int num){
        return this.combatants.get(num);
    }
    public int getCombatantsNumber() {
        return combatantsNumber;
    }
}
class DataEnhancement{
             // Import the Scanner class
    private Scanner scan;

    DataEnhancement(){
        scan = new Scanner(System.in);
    }

    public String scanf(){
        return this.scan.nextLine();
    }
}
/*
class PlayableCharacter extends Character{

}
class NonPlayableCharacter extends Character{

}*/