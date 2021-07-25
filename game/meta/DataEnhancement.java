package game.meta;

import java.util.Scanner;

public class DataEnhancement{
    // Import the Scanner class
    private Scanner scan;

    public DataEnhancement(){
        this.scan = new Scanner(System.in);
    }

    public String scanf(){
        return this.scan.nextLine();
    }
}