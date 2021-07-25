package game.character;

public class CharacterForge {
    static public Character ForgeWarrior(String n){
        CharacterClass cc = new CharacterClass(15, 0, 0, 12, 0, 20, 0);
        Character newChar = new Character(n, cc);

        newChar.setCharClass(cc); 

        return newChar;
    }
}
