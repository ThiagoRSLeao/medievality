package game.item.attachable;
import game.item.type.Attachable;

public class Lantern extends Attachable{
    private String color;
    private int maxFuel;//turnos
    private int fuel;//turnos
    private double radius;//metros
    private boolean turnedOn;//metros

    public Lantern(){
        this.name = "Lanterna";
        this.weight = 2.5;
        this.color = "Branca";
        this.maxFuel = 100;
        this.fuel = 100;
        this.radius = 9.0;
        this.turnedOn = false;//metros
    }
    public Lantern(String name, double weight, String color, int maxFuel, Double radius){
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.maxFuel = maxFuel;
        this.fuel = maxFuel;
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public Double getRadius() {
        return radius;
    }
    public int getFuel() {
        return fuel;
    }
    public String getRemainingTime() {
        return String.format("%,.0f",((double) (fuel) / (double) maxFuel) * 100) + "%";
    }
    public boolean switchTurnOn(){
        if(this.fuel > 0) this.turnedOn = !this.turnedOn;
        return this.turnedOn;
    }
    public boolean consumeFuel(int turns){        
        this.fuel -= turns; 
        return this.checkFuel(); 
    }
    public boolean checkFuel(){
        if(this.fuel <= 0) 
        {
            this.turnedOn = false;   
            return false;
        } 
        return true;
    }
    public boolean turnedTurns(int turnNum){
        if(this.turnedOn) return consumeFuel(turnNum);
        else return false;
    }
}