package org.example;

import java.util.Scanner;

public class Cube {
    public static void main(String[] args) {
        // Volym av en kub = bredd * djup * höjd (där alla är likadana så x^3)
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
