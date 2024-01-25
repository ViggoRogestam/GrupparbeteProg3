package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klass som beräknar volymen av ett klot.
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

public class Sphere {
    public static void main(String[] args) {
        // Volym av en klot är (4 * π * r^3) / 3
        double radius;

        Scanner scan = new Scanner(System.in);

        // Hanterar felinmatning i en while-loop och
        while (true) {
            try {
                System.out.println("Input the radius of the sphere in decimeter: ");
                radius = scan.nextDouble();
                break; // Om inläsningen är lyckad, bryt ut ur loopen
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                scan.next(); // Rensa scanner bufferten från felaktig inmatning
            }
        }

        double volume = calculateVolume(radius);
        System.out.println("The volume of the sphere is: " + volume + " litre");
    }

    // Beräkningen av ett klot, Math.pow = radius^3
    public static double calculateVolume(double radius) {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }
}
