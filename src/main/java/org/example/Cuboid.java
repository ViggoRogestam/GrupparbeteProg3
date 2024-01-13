package org.example;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the width of the cuboid in decimetre: ");
        width = scanner.nextDouble();

        System.out.println("Input the depth of the cuboid in decimetre: ");
        depth = scanner.nextDouble();

        System.out.println("Input the height of the cuboidin decimetre: ");
        height = scanner.nextDouble();

        double volume = calculateVolume(width, depth, height);
        System.out.println("Volume of the rectangular block: " + volume + " litre");
    }

    public static double calculateVolume(double width, double depth, double height) {
        return width * depth * height;
    }
}