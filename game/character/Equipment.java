package game.character;

import game.item.equipment.*;
import game.item.type.EquipableItem;

public class Equipment{
    private Character belongCharacter;
    //Armor
    private ArmorPiece head;
    private ArmorPiece chest;
    private ArmorPiece arms;
    private ArmorPiece legs;

    //Weapons
    private Weapon mainHand;
    private Weapon offHand;

    //Jewelry
    private Jewelry necklace;
    private Jewelry ring1;
    private Jewelry ring2;

    public Equipment(Character character){
        this.belongCharacter = character;
        this.head = null;
        this.chest = null;
        this.arms = null;
        this.legs = null;

        this.mainHand = null;
        this.offHand = null;

        this.necklace = null;
        this.ring1 = null;
        this.ring2 = null;
    }
    public boolean setEquip(Weapon equip){
        switch(equip.getWhere()){
            case "M":  
                if(this.mainHand == null) {
                    //Desequipar                       
                }
                System.out.println("Armar M" + equip.getName());
                this.mainHand = equip; 
                return true;
            case "O":  
                //if(this.offHand == null) {
                    //Desequipar               
                //}
                this.offHand = equip; 
                return true; 
            case "T":  
                if(this.offHand != null && this.mainHand != null) {
                    this.unEquip(equip.getWhere()); 
                }
                System.out.println("Armar T" + equip.getName());
                this.mainHand = equip;
                this.offHand = equip; 
                return true;
        }
        return false;
    }
    public boolean setEquip(ArmorPiece equip){
        switch(equip.getWhere()){
            case "H":  
                if(this.head == null) this.unEquip(equip.getWhere());
                this.head = equip; 
                return true;
            case "C":  
                if(this.chest == null) this.unEquip(equip.getWhere());
                this.chest = equip; 
                return true;
            case "A":  
                if(this.arms == null) this.unEquip(equip.getWhere());
                this.arms = equip; 
                return true;
            case "L":  
                if(this.legs == null) this.unEquip(equip.getWhere());
                this.legs = equip; 
                return true;
        }
        return false;
    }
    public boolean setEquip(Jewelry equip){
        switch(equip.getWhere()){
            case "N":  if(this.necklace == null) 
                this.necklace = equip; 
                return true;

            case "R":  if(this.ring1 == null || this.ring2 == null) 
                if(this.ring1 == null) this.ring1 = equip;
                else this.ring2 = equip; return true;
        }
        return false;
    }
    public EquipableItem getEquip(String where){
        switch(where){
            case "M":  if(this.mainHand != null) return this.mainHand;
            case "O":  if(this.offHand != null) return this.offHand;
            case "T":  if(this.offHand != null && this.mainHand == this.offHand) return this.mainHand;
            case "H":  if(this.head != null) return this.head;
            case "C":  if(this.chest != null) return this.chest;
            case "A":  if(this.arms != null) return this.arms;
            case "L":  if(this.legs != null) return this.legs;
            case "N":  if(this.necklace != null) return this.necklace;
            case "R1":  if(this.ring1 != null) return this.ring1;
            case "R2":  if(this.ring2 != null) return this.ring2;
            default: return null;
        }        
    }
    public Weapon getWielding(){
        return this.mainHand;
    }
    public boolean unEquip(String where)
    {
        this.belongCharacter.addInvetory(getEquip(where), true);
        switch(where){
            case "M": 
                this.mainHand = null;
                break;
            case "O": 
                this.offHand = null;
                break;
            case "T": 
                this.mainHand = null;
                this.offHand = null;
                break;
            case "H": 
                this.head = null;
                break;
            case "C": 
                this.chest = null;
                break;
            case "A": 
                this.arms = null;
                break;
            case "L": 
                this.legs = null;
                break;
            case "N": 
                this.necklace = null;
                break;
            case "R1": 
                this.ring1 = null;
                break;
            case "R2": 
                this.ring2 = null;
                break;
        }  
        return true;
    }
}