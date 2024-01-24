package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klass som beräknar volymen av ett rätblock.
 * <hr>
 * Skapad av <b>Anton Lövgren</b>
 * <br>
 * Datum: 2024-01-13
 * Tid: 18:18
 * <br>
 * Projekt: GrupparbeteProg3
 * <br>
 * Upphovsrätt: MIT
 */

public class Cuboid {
    public static void main(String[] args) {
        // Volym av ett rätblock = bredd * djup * höjd
        double width;
        double depth;
        double height;

        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Input the width of the cuboid in decimeter: ");
                width = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                scan.next();
            }
        }

        while (true) {
            try {
                System.out.println("Input the depth of the cuboid in decimeter: ");
                depth = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                scan.next();
            }
        }

        while (true) {
            try {
                System.out.println("Input the height of the cuboid in decimeter: ");
                height = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                scan.next();
            }
        }


        double volume = calculateVolume(width, depth, height);
        System.out.println("Volume of the rectangular block: " + volume + " litre");
    }

    public static double calculateVolume(double width, double depth, double height) {
        return width * depth * height;
    }
}