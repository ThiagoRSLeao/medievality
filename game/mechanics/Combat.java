
package game.mechanics;
import java.util.*;

import game.character.Character;
import game.meta.DataEnhancement;

public class Combat{
    private ArrayList<Character> combatants;
    private int combatantsNumber;
    private int actualTurn;
    private boolean combatEnds;
    private DataEnhancement de;

    public Combat(){
        this.combatants = new ArrayList<Character>();
        this.combatantsNumber = 0;
        this.actualTurn = 0;
        this.de = new DataEnhancement();
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
        this.turnOptions(combatants.get(actualTurn));//while(!combatants.get(actualTurn).doTurn(this));        
        if(actualTurn < this.combatantsNumber-1) actualTurn += 1;
        else
        {
            actualTurn = 0;
            //this.check
        }
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
    public boolean turnOptions(Character character){
        System.out.println("Oque deseja fazer " + character.getName() + "?");

        System.out.println("1 - Atacar.");
        System.out.println("2 - Mover.");
        System.out.println("3 - Fugir.");

        System.out.print("Resposta: ");
        int choice = Integer.parseInt(this.de.scanf());

        ArrayList<Character> otherCharacters = new ArrayList<Character>();
        System.out.println("---- Possiveis alvos ----");
        for(int counter = 0; counter < this.getCombatantsNumber(); counter++){
            if(character == this.getCombatants().get(counter)) continue;
            otherCharacters.add(this.getCombatants().get(counter));
        }

        switch (choice) {
            case 1:
                for(int counter = 0; counter < otherCharacters.size(); counter++){
                    System.out.println(counter+1 +" - "+ otherCharacters.get(counter).getName());
                }

                int target = -1;
                while(target >= otherCharacters.size() || target < 0){
                    System.out.println("Quem deseja quer atacar? ");
                    System.out.print("Resposta: ");
                    target = Integer.parseInt(this.de.scanf()) - 1;
                }
                
                otherCharacters.get(target);
                character.attack(otherCharacters.get(target));
                break;
            /*case 3:
                ArrayList<Character> players = new ArrayList<Character>();

                System.out.println("Tentando correr...");
                int run = character.getSpeed();
                for(int counter = 0; counter < otherCharacters.size(); counter++){
                    otherCharacters.get(counter);
                }
                break;*/
        
            default:
                System.out.println("Ainda não implementado!");
                break;
        }
        //turnedTurns
        return true;
    }
}
