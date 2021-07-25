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

    public CharacterAttributes(){
        this.strength = new Attribute("STR", 10);
        this.dexterity = new Attribute("DEX", 10);
        this.constitution = new Attribute("CON", 10);
        this.inteligence = new Attribute("INT", 10);
        this.wisdom = new Attribute("WIS", 10);
        this.charisma = new Attribute("CHA", 10);
        this.VA = new Attribute("VOID", 0);
    }

    public CharacterAttributes(int[] attributes){
        this.strength = new Attribute("STR", attributes[0]);
        this.dexterity = new Attribute("DEX", attributes[1]);
        this.constitution = new Attribute("CON", attributes[2]);
        this.inteligence = new Attribute("INT", attributes[3]);
        this.wisdom = new Attribute("WIS", attributes[4]);
        this.charisma = new Attribute("CHA", attributes[5]);
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
    public void setAttribute(String attributeShort,int val){
        switch (attributeShort) {
            case "STR": this.strength.setAttribute(val);
            case "DEX": this.dexterity.setAttribute(val);       
            case "CON": this.constitution.setAttribute(val);
            case "INT": this.inteligence.setAttribute(val);  
            case "WIS": this.wisdom.setAttribute(val);      
            case "CHA": this.charisma.setAttribute(val);
            /*default: return NULL;  break;*/
        }
    } 
    public void changeAttribute(String attributeShort,int val){
        switch (attributeShort) {
            case "STR": this.strength.changeAttribute(val);
            case "DEX": this.dexterity.changeAttribute(val);       
            case "CON": this.constitution.changeAttribute(val);
            case "INT": this.inteligence.changeAttribute(val);  
            case "WIS": this.wisdom.changeAttribute(val);      
            case "CHA": this.charisma.changeAttribute(val);
            /*default: return NULL;  break;*/
        }
    }
}
