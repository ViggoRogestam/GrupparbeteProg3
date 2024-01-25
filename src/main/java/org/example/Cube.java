package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klass som beräknar volymen av en kub.
 * <hr>
 * Skapad av <b>Anton Lövgren</b>
 * <br>
 * Datum: 2024-01-13
 * Tid: 18:17
 * <br>
 * Projekt: GrupparbeteProg3
 * <br>
 * Upphovsrätt: MIT
 */

public class Cube {
    public static void main(String[] args) {
        // Volym av en kub är bredd * djup * höjd (där alla är likadana så x^3)
        double sideLength;

        Scanner scan = new Scanner(System.in);

        // Hanterar felinmatningar i while-loopen
        while (true) {
            try {
                System.out.println("Input the side length of the cube in decimeter: ");
                sideLength = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                scan.next();
            }
        }

        double volume = calculateVolume(sideLength);
        System.out.println("The volume of the cube is: " + volume + " litre");

    }

    // Skapar metod för att kunna köra tester
    public static double calculateVolume(double sideLength) {
        // Math.pow = https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
        // Volume = sideLength^3
        return Math.pow(sideLength, 3);
    }
}
