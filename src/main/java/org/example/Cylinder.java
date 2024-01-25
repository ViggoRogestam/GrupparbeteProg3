package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klass som beräknar volymen av en cylinder.
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

public class Cylinder {
    public static void main(String[] args) {
        // Volym av en cylinder = π * r^2 * h
        double radius;
        double height;

        Scanner scan = new Scanner(System.in);

        // Hanterar felinmatningar i while-looparna
        while (true) {
            try {
                System.out.println("Input the radius of the cylinder in decimeter: ");
                radius = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                scan.next();
            }
        }

        while (true) {
            try {
                System.out.println("Input the height of the cylinder in decimeter: ");
                height = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                scan.next();
            }
        }

        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("The volume of the cylinder is: " + volume + " litre");
    }

    // Formel för volym av en cylinder, Math.pow = radius^2
    public static double calculateVolume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}