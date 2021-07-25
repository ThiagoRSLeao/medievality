package game.character;
import java.util.ArrayList;
import java.util.Set;

public class ActualStats extends Stats{

    public ActualStats() {
        for(int counter = 0; counter < stats.size(); counter++)
        {
            this.ac += stats.get(counter).ac;
            this.shield += stats.get(counter).shield;
            this.hp += stats.get(counter).hp;
            this.mana += stats.get(counter).mana;
            this.speed += stats.get(counter).speed;
            this.profBonus += stats.get(counter).profBonus;
            this.actionsPerTurn += stats.get(counter).actionsPerTurn;
            this.minorActionsPerTurn += stats.get(counter).minorActionsPerTurn;
        }
    }
    public void changeAc(int ac) 
    {
        this.ac += ac;
    }
    public void changeShield(int shield) 
    {
        this.shield += shield;
    }
    public void changeHp(int hp) 
    {
        this.hp += hp;
    }
    public void changeMana(int mana) 
    {
        this.mana += mana;
    }
    public void changeSpeed(int speed) 
    {
        this.speed += speed;
    }
    public void changeProfBonus(int profBonus) 
    {
        this.profBonus += profBonus;
    }
    public void changeActionsPerTurn(int actionsPerTurn) 
    {
        this.actionsPerTurn += actionsPerTurn;
    }
    public void changeMinorActionsPerTurn(int minorActionsPerTurn) 
    {
        this.minorActionsPerTurn += minorActionsPerTurn;
    }
}
