package game.item.type;
import game.item.AttachSockets;
import game.property.Property;
import game.item.type.Socketable;


public abstract class Attachable extends Socketable{
    private AttachSockets attachedTo;
    private int attachedAt; //index
    private Property property; //index
    
    public Attachable(){
        this.attachedTo = null;
        this.attachedAt = -1;
    }
    public Property getProperty(){
        return this.property;
    }
}