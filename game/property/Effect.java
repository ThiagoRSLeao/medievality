package game.property;

import game.property.Property;

public class Effect{
    private Property property;
    private int duration;

    Effect(Property p, int duration)
    {
        this.property = p;
        this.duration = duration;
    }
    public boolean turnedTurns(int turns){
        this.duration -= turns;
        if(duration <= 0) return true; 
        else return false;
    }
}