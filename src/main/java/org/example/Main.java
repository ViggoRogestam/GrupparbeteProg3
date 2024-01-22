package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args){
        var scan = new Scanner(System.in);
        int indata;
        while (true){
            System.out.println("""
                 ..:: Coordinate System ::..
                
                ------------------------------------------------------------

                1. Calculate the length between two points
                2. Find the midpoint between two points
                3. Show the most recent midpoints (max 5 most recent)
                
                ------------------------------------------------------------""");
            try {
                indata = scan.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Error: Invalid input");
                continue;
            }
            switch (indata){
                case 1:
                    continue;
                case 2:
                    continue;
                case 3:
                    continue;
                case 4:
                    continue;
                case 5:
                    continue;
                case 6:
                    continue;
                case 7:
                    continue;
                case 8:
                    continue;
                default:
                    System.out.println("Invalid input");

            }






        }
    }
}

// class main
    // public static void

    //loop that runs the program

    //if-statments to choose which converter to use (area, volumes etc.)

    //when choosen run a loop inside the loop that runs an imported method with the code to run the calculation

    //print result and ask user if they want to run the method again or
    //go back to the main loop and choose another calculation

