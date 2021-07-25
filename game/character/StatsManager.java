package game.character;
import java.util.ArrayList;

public class StatsManager {
    
    private ArrayList<Stats> permanentStats;
    private Stats permStats; //Atual
    private ArrayList<Stats> tempStats;
    private Stats actualStats; //Atual
    

    StatsManager(){
        this.permanentStats = new ArrayList<Stats>();
        this.tempStats = new ArrayList<Stats>();
        this.permStats = new Stats("Status base.");
        this.actualStats = new Stats("Status atuais.");

    }
    StatsManager(ArrayList<Stats> permanentStats){
        this.permanentStats = permanentStats;
        this.tempStats = new ArrayList<Stats>();

        for(int counter = 0; counter < this.permanentStats.size(); counter++)
        {
            this.permStats.maxShield += this.permanentStats.get(counter).maxShield;
            this.permStats.maxHp += this.permanentStats.get(counter).maxHp;
            this.permStats.maxMana += this.permanentStats.get(counter).maxMana;
            this.permStats.speed += this.permanentStats.get(counter).speed;
            this.permStats.evasion += this.permanentStats.get(counter).evasion;
            this.permStats.profBonus += this.permanentStats.get(counter).profBonus;

            this.permStats.physicalDamage += this.permanentStats.get(counter).physicalDamage;
            this.permStats.magicalDamage += this.permanentStats.get(counter).magicalDamage;

            this.permStats.criticalChance += this.permanentStats.get(counter).criticalChance;
            this.permStats.criticalDamage += this.permanentStats.get(counter).criticalDamage;

            this.permStats.actionsPerTurn += this.permanentStats.get(counter).actionsPerTurn;
        }
        this.setActualStats();
    }
    public void setActualStats(){
        
        this.actualStats.maxShield = this.permStats.maxShield;
        this.actualStats.maxHp = this.permStats.maxHp;
        this.actualStats.maxMana = this.permStats.maxMana;
        this.actualStats.speed = this.permStats.speed;
        this.actualStats.evasion = this.permStats.evasion;
        this.actualStats.profBonus = this.permStats.profBonus;

        this.actualStats.physicalDamage = this.permStats.physicalDamage;
        this.actualStats.magicalDamage = this.permStats.magicalDamage;

        this.actualStats.criticalChance = this.permStats.criticalChance;
        this.actualStats.criticalDamage = this.permStats.criticalDamage;

        this.actualStats.actionsPerTurn = this.permStats.actionsPerTurn;
        this.updateStats();
    }
    public void updateStats(){
        
        for(int counter = 0; counter < this.tempStats.size(); counter++)
        {
            this.actualStats.maxShield += this.tempStats.get(counter).maxShield;
            this.actualStats.maxHp += this.tempStats.get(counter).maxHp;
            this.actualStats.maxMana += this.tempStats.get(counter).maxMana;
            this.actualStats.speed += this.tempStats.get(counter).speed;
            this.actualStats.evasion += this.tempStats.get(counter).evasion;
            this.actualStats.profBonus += this.tempStats.get(counter).profBonus;
            this.actualStats.actionsPerTurn += this.tempStats.get(counter).actionsPerTurn;
        }
    }
    public void insertBaseStats(Stats base){
        this.permanentStats.add(base);

        this.permStats.maxShield += base.maxShield;
        this.permStats.maxHp += base.maxHp;
        this.permStats.maxMana += base.maxMana;
        this.permStats.speed += base.speed;
        this.permStats.evasion -= base.evasion;
        this.permStats.profBonus += base.profBonus;

        this.permStats.physicalDamage += base.physicalDamage;
        this.permStats.magicalDamage += base.magicalDamage;

        this.permStats.criticalChance += base.criticalChance;
        this.permStats.criticalDamage += base.criticalDamage;

        this.permStats.actionsPerTurn += base.actionsPerTurn;
    }
    public void insertTempStats(Stats temp){
        this.tempStats.add(temp);

        this.actualStats.maxShield += temp.maxShield;
        this.actualStats.maxHp += temp.maxHp;
        this.actualStats.maxMana += temp.maxMana;
        this.actualStats.speed += temp.speed;
        this.actualStats.evasion -= temp.evasion;
        this.actualStats.profBonus += temp.profBonus;

        this.actualStats.physicalDamage += temp.physicalDamage;
        this.actualStats.magicalDamage += temp.magicalDamage;

        this.actualStats.criticalChance += temp.criticalChance;
        this.actualStats.criticalDamage += temp.criticalDamage;

        this.actualStats.actionsPerTurn += temp.actionsPerTurn;
    }
    public void removeTempStats(Stats temp){
        if(this.tempStats.contains(temp)){
            this.tempStats.remove(temp);

            this.actualStats.maxShield -= temp.maxShield;
            this.actualStats.maxHp -= temp.maxHp;
            this.actualStats.maxMana -= temp.maxMana;
            this.actualStats.speed -= temp.speed;
            this.actualStats.evasion -= temp.evasion;
            this.actualStats.profBonus += temp.profBonus;
    
            this.actualStats.physicalDamage -= temp.physicalDamage;
            this.actualStats.magicalDamage -= temp.magicalDamage;
    
            this.actualStats.criticalChance -= temp.criticalChance;
            this.actualStats.criticalDamage -= temp.criticalDamage;
    
            this.actualStats.actionsPerTurn -= temp.actionsPerTurn;
        }        
    }
    public int getMaxHp(){
        return this.actualStats.maxHp;
    }
    public int getMaxMana(){
        return this.actualStats.maxMana;
    }
    public int getMaxShield(){
        return this.actualStats.maxShield;
    }
    public double getSpeed(){
        return this.actualStats.speed;
    }
    public int getEvasion(){
        return this.actualStats.evasion;
    }
    public int getProfBonus(){
        return this.actualStats.profBonus;
    }
    public int getPhysicalDamage(){
        return this.actualStats.physicalDamage;
    }
    public int getMagicalDamage(){
        return this.actualStats.magicalDamage;
    }
    public int getCriticalChance(){
        return this.actualStats.criticalChance;
    }
    public int getCriticalDamage(){
        return this.actualStats.criticalDamage;
    }
    public int getActionsPerTurn(){
        return this.actualStats.actionsPerTurn;
    }
    public void showStats(){    
        for(int counter = 0; counter < this.permanentStats.size(); counter++){
            this.permanentStats.get(counter).showStats();
        }
        this.permStats.showStats();
        for(int counter = 0; counter < this.tempStats.size(); counter++){
            this.tempStats.get(counter).showStats();
        }
        this.actualStats.showStats();    
    }
}
