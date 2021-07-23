
package game.mechanics;
import java.util.*;

import game.character.Character;

public class Combat{
    ArrayList<Character> combatants;
    int combatantsNumber;
    int actualTurn;
    boolean combatEnds;

    public Combat(){
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
