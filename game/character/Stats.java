package game.character;


public class Stats {
    private String origin;
    protected int evasion;
    protected int maxShield;
    protected int maxHp;
    protected int maxMana;
    protected double speed;
    protected int profBonus;

    protected int physicalDamage;
    protected int magicalDamage;
    protected int spiritualDamage;

    protected int criticalChance;
    protected int criticalDamage;

    protected int actionsPerTurn;
    public Stats(){
        this.origin = "";
        this.evasion = 0;
        this.maxShield = 0;
        this.maxHp = 0;
        this.maxMana = 0;
        this.speed = 0;
        this.profBonus = 0;

        this.physicalDamage = 0;
        this.magicalDamage = 0;
        this.spiritualDamage = 0;
    
        this.criticalChance = 0;
        this.criticalDamage = 0;
    
        this.actionsPerTurn = 0;
    }
    public Stats(String name){
        this.origin = name;
        this.evasion = 0;
        this.maxShield = 0;
        this.maxHp = 0;
        this.maxMana = 0;
        this.speed = 0;
        this.profBonus = 0;

        this.physicalDamage = 0;
        this.magicalDamage = 0;
        this.spiritualDamage = 0;
    
        this.criticalChance = 0;
        this.criticalDamage = 0;
    
        this.actionsPerTurn = 0;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setMaxShield(int maxShield) {
        this.maxShield = maxShield;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setProfBonus(int profBonus) {
        this.profBonus = profBonus;
    }
    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }
    public void setCriticalDamage(int criticalDamage) {
        this.criticalDamage = criticalDamage;
    }
    public void setSpiritualDamage(int spiritualDamage) {
        this.spiritualDamage = spiritualDamage;
    }
    public void setMagicalDamage(int magicalDamage) {
        this.magicalDamage = magicalDamage;
    }
    public void setPhysicalDamage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }
    public void setActionsPerTurn(int actionsPerTurn) {
        this.actionsPerTurn = actionsPerTurn;
    }
    public int getMaxShield() {
        return maxShield;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public double getSpeed() {
        return speed;
    }
    public int getProfBonus() {
        return profBonus;
    }
    public int getCriticalChance() {
        return criticalChance;
    }
    public int getCriticalDamage() {
        return criticalDamage;
    }
    public int getSpiritualDamage() {
        return spiritualDamage;
    }
    public int getMagicalDamage() {
        return magicalDamage;
    }
    public int getPhysicalDamage() {
        return physicalDamage;
    }
    public int getActionsPerTurn() {
        return actionsPerTurn;
    }
    public void showStats(){    
        System.out.println("Status de "+ this.origin);
        System.out.println("Vida: " + this.maxHp);
        System.out.println("Mana: " + this.maxMana);
        System.out.println("Shield: " + this.maxShield);
        System.out.println("Evasão: " + this.evasion);
        System.out.println("Velocidade: " + this.speed);
        System.out.println("Proficiência: " + this.profBonus);
        System.out.println("Dano Físico: " + this.physicalDamage);
        System.out.println("Dano Mágico: " + this.magicalDamage);
        System.out.println("Chance de Crítico: " + this.criticalChance);
        System.out.println("Dano Crítico: " + this.criticalDamage);
        System.out.println("Pontos de Ação: " + this.actionsPerTurn);
    }
}
