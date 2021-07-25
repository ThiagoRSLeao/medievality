package game.character;


public class Stats {
    
    protected int ac;
    protected int shield;
    protected int hp;
    protected int mana;
    protected double speed;
    protected int profBonus;

    protected int actionsPerTurn;
    protected int minorActionsPerTurn;

    public Stats(){
        this.ac = 0;
        this.shield = 0;
        this.hp = 0;
        this.mana = 0;
        this.speed = 0;
        this.profBonus = 0;
        this.actionsPerTurn = 1;
        this.minorActionsPerTurn = 1;
    }
    public void setAc(int ac) {
        this.ac = ac;
    }
    public void setShield(int shield) {
        this.shield = shield;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setProfBonus(int profBonus) {
        this.profBonus = profBonus;
    }
    public void setActionsPerTurn(int actionsPerTurn) {
        this.actionsPerTurn = actionsPerTurn;
    }
    public void setMinorActionsPerTurn(int minorActionsPerTurn) {
        this.minorActionsPerTurn = minorActionsPerTurn;
    }
    public int getAc() {
        return ac;
    }
    public int getShield() {
        return shield;
    }
    public int getHp() {
        return hp;
    }
    public int getMana() {
        return mana;
    }
    public double getSpeed() {
        return speed;
    }
    public int getProfBonus() {
        return profBonus;
    }
    public int getActionsPerTurn() {
        return actionsPerTurn;
    }
    public int getMinorActionsPerTurn() {
        return minorActionsPerTurn;
    }    
}
