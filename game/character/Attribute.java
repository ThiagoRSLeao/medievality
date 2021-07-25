package game.character;

public class Attribute{
    String name;
    String shortName;
    int value;
    int mod;
    public Attribute(String attributeShort){
        switch (attributeShort) {
            case "STR": this.name = "Strength";      break;
            case "DEX": this.name = "Dexterity";     break;
            case "CON": this.name = "Constitution";  break;
            case "INT": this.name = "Inteligence";   break;
            case "WIS": this.name = "Wisdom";        break;
            case "CHA": this.name = "Charisma";      break;        
            //default:    erro                  break;
        }
        this.shortName = attributeShort;
    }
    public Attribute(String attributeShort, int value){
        switch (attributeShort) {
            case "STR": this.name = "Strength";      break;
            case "DEX": this.name = "Dexterity";     break;
            case "CON": this.name = "Constitution";  break;
            case "INT": this.name = "Inteligence";   break;
            case "WIS": this.name = "Wisdom";        break;
            case "CHA": this.name = "Charisma";      break;        
            //default:    erro                  break;
        }
        this.shortName = attributeShort;
        this.value = value;
        this.calcMod();
    }
    void calcMod(){
        int mod = -5;
        int i = this.value;
        while(i > 1){
            mod += 1;
            i = i - 2;
        }
        this.mod = mod;
    }
    public int getMod() {
        return this.mod;
    }
    public String getShortName() {
        return this.shortName;
    }
    public void setAttribute(int val){    
        this.value = val;    
        this.calcMod();
    }
    public void changeAttribute(int val){    
        this.value += val;    
        this.calcMod();
    }
}