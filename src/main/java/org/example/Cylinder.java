package org.example;

import java.util.Scanner;

public class Cylinder {
    public static void main(String[] args) {
        // Volym av en cylinder = π * r^2 * h
        double radius;
        double height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the radius of the cylinder in decimetre: ");
        radius = scanner.nextDouble();

        System.out.println("Input the height of the cylinder in decimetre: ");
        height = scanner.nextDouble();

        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("The volume of the cylinder is: " + volume + " litre");
    }

    public static double calculateVolume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}