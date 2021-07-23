package game.property;

public class Property{
    private int id;
    private int value;
    Property(int id, int value){
        this.id = id;
        this.value = value;
    }
    public int getId() {
        return id;
    }
    public int getValue() {
        return value;
    }
}
