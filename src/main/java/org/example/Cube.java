package org.example;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the side length of the cube in decimetre: ");
        sideLength = scanner.nextDouble();

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
