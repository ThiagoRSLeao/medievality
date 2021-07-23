package game.mechanics;

import java.util.Random;

public class Dice{
    private int minRaw;
    private int maxRaw;
    private int times;
    private Random rand;

    public Dice(int minRaw, int maxRaw, int times){
        this.rand = new Random();
        this.minRaw = minRaw;
        this.maxRaw = maxRaw;
        this.times = times;
    }
    public int roll(int mod){
        if(maxRaw == minRaw) return 1 + mod;
        int roll = rand.nextInt(maxRaw - minRaw) + minRaw + mod;
        for(int c = 1; c < this.times; c++) roll += rand.nextInt(maxRaw - minRaw);
        return roll;
    }
}