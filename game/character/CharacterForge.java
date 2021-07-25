package game.character;

public class CharacterForge {
    static public Character ForgeWarrior(String n){
        //CharacterClass cc = new CharacterClass(15, 0, 0, 12, 0, 20, 0);
        Character newChar = new Character(n);
        Stats baseStats = new Stats();
        ClassStats classStats = new ClassStats(25.5, 0.0, 10.25, 0.0, 0.0, 0.25, 5.5, 0.0, 0.0, 2.0, 5.0, 0.10);
        

        //newChar.setCharClass(cc); 

        return newChar;
    }
}
