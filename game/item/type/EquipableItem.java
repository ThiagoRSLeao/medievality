package game.item.type;
public abstract class EquipableItem extends Item{
    protected int durability;
    protected String where;
    //private ArrayList<Property> properties;

    public EquipableItem(){        
        this.durability = 0;
        this.where = "";
    }

    public void setWhere(String where) {
        this.where = where;
    }
    public String getWhere() {
        return this.where;
    }
    
}