package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //int indata;
        while (true) {
            System.out.println("""
                     . .:: Coordinate System ::..
                                    
                    ------------------------------------------------------------

                    1. Calculate the length between two points
                    2. Find the midpoint between two points
                    3. Show the most recent midpoints (max 5 most recent)
                                    
                    ------------------------------------------------------------""");
            int indata;
            while (true) {
                try {
                    indata = scan.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input");
                    scan.next(); // clear the scanner buffer
                }
            }
            switch (indata) {
                case 1:
                    while (true) {
                        //declare variables
                        double orgTemp;
                        String fromUnit, toUnit, anwser;
                        //ask user for input
                        try {
                            System.out.println("Enter temperature:");
                            orgTemp = scan.nextDouble();
                            System.out.println("Enter temperature unit (celcsius, farneheit or kelvin):");
                            fromUnit = scan.next();
                            System.out.println("Enter unit to convert to (celcsius, farneheit or kelvin)");
                            toUnit = scan.next();

                            //run convTemp class-method to convert temperature & print it out
                            System.out.println(TemperatureUnits.convTemp(orgTemp, fromUnit, toUnit));
                        } catch (Exception e) {
                            System.out.println("Invalid input" + e);
                            scan.nextLine(); // consume the next token, not the entire line
                        } finally {
                            System.out.println("\nDo you want to convert again (y/n)?");
                            anwser = scan.next();

                            //ask user if they want to continue the convertions or exit out of case 1
                            if (!Objects.equals(anwser, "y"))
                                break;
                        }
                    }


                case 2:
                    while (true) {
                        // Call the main method of the Area class
                        Area.main(args);

                        // Ask the user if they want to run the program again
                        System.out.print("\nDo you want to run the program again? (y/n): ");
                        String userInput = scan.next();

                        // If the user enters anything other than 'y', exit the loop
                        if (!userInput.equalsIgnoreCase("y")) {
                            System.out.println("Exiting the program. Goodbye!");
                            break;
                        }
                    }
                case 3:
                    while (true) {
                        // Call the main method of the CoordinateSystem class
                        CoordinateSystem.main(args);

                        // Ask the user if they want to run the program again
                        System.out.print("Do you want to run the program again? (y/n): ");
                        String userInput = scan.next();

                        // If the user enters anything other than 'y', exit the loop
                        if (!userInput.equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
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
