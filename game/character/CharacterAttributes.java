package game.character;
import game.character.Attribute;

public class CharacterAttributes {
    Attribute strength;
    Attribute dexterity;
    Attribute constitution;
    Attribute inteligence;
    Attribute wisdom;
    Attribute charisma;
    Attribute VA;

    public CharacterAttributes(int strength, int dexterity, int constitution, int inteligence, int wisdom, int charisma){
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
