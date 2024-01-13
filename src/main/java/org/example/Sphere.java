package org.example;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the radius of the sphere in decimetre: ");
        radius = scanner.nextDouble();

        double volume = calculateVolume(radius);
        System.out.println("The volume of the sphere is: " + volume + " litre");
    }

    public static double calculateVolume(double radius) {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }
}
