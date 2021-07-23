package game.item;

import game.item.type.Attachable;
import java.util.*;

public class AttachSockets{
    private int numberSockets;// 0 = Lantern, 1 = Trinket, 2 = Extra
    private ArrayList<Attachable> sockets;

    public AttachSockets(int numberSockets){
        this.numberSockets = numberSockets;
        this.sockets = new ArrayList<Attachable>();
    }
    public boolean putFreeSocket(Attachable item){        
        if(this.sockets.size() < this.numberSockets){
            this.sockets.add(item);
            return true;
        }
        else return false;
    }
    public boolean removeSocket(Attachable item){  
        for(int counter = 0; counter < sockets.size(); counter++)
        {
            if(item == this.sockets.get(counter)) 
            {
                sockets.remove(counter);
                return true;
            }
        }    
        return false;  
    }
    public int getNumberSockets() {
        return numberSockets;
    }
}