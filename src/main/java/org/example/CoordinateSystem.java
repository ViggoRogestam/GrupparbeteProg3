package org.example;

import java.awt.*;
import java.util.Scanner;


/**
 * Created by Lina Romilson
 * Date: 2024-01-15
 * Time: 14:10
 * Project GrupparbeteProg3
 * Copyright: MIT
 */
public class CoordinateSystem {
    public static void main(String[] args) {
        // Skapa meny med if-else sats för att kunna välja vilket av alternativen man vill utföra
        System.out.println("""
                 ..:: Coordinate System ::..
                
                ------------------------------------------------------------

                1. Calculate the length between two points
                2. Find the midpoint between two points
                3. Find out if the points make a vertical/horizontal line
                4. Calculate the tilt of the line
                5. Show the most recent midpoints (max 5 most recent)
                
                ------------------------------------------------------------""");
        Scanner scan = new Scanner(System.in);
        System.out.println("Select an option from the menu: ");
        int choice = scan.nextInt();

        // Alt. 1 beräkna längd mellan två punkter
        if (choice == 1)
            distance();

        // Alt. 2 få fram mittpunkten mellan två punkter (spara punkten i en array?)
        else if (choice == 2) {
            CustomPoint middle = middlePoint();
            System.out.println("mittenpunkten är: " + middle);
            arrayPoints(middle);
            System.out.println();
        }
        // Alt. 3 ligger 3 punkter på samma linje?
        // Alt. 4 beräkna lutningen på linjen som går mellan två punkter
        // Alt. 5 visa senaste 5 mittpunkterna (max 5 senaste)
            // Om ingen mittpunkt är angiven visa meddelande om det
    }
    // beräkna längd mellan två punkter
    static String distance () {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the x-coordinate for point 1: ");
        double x1 = scan.nextDouble();
        System.out.print("Enter the y-coordinate for point 1: ");
        double y1 = scan.nextDouble();
        System.out.print("Enter the x-coordinate for point 2: ");
        double x2 = scan.nextDouble();
        System.out.print("Enter the y-coordinate for point 2: ");
        double y2 = scan.nextDouble();
        double distance = Point.distance(x1, y1, x2, y2);
        return "The distance between point 1 and point 2 is: ";
    }
    // få fram mittpunkten mellan två punkter (spara punkten i en array?)
    static CustomPoint middlePoint () {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the x-coordinate for point 1: ");
        double x1 = scan.nextDouble();
        System.out.print("Enter the y-coordinate for point 1: ");
        double y1 = scan.nextDouble();
        System.out.print("Enter the x-coordinate for point 2: ");
        double x2 = scan.nextDouble();
        System.out.print("Enter the y-coordinate for point 2: ");
        double y2 = scan.nextDouble();

        double middleX = (x1 + x2) / 2;
        double middleY = (y1 + y2) / 2;
        return new CustomPoint(middleX, middleY);

    }
    // Egen metod för att spara mittpunkten i en array
    static CustomPoint[] arrayPoints(CustomPoint middle) {
        Scanner scan = new Scanner(System.in);
        CustomPoint[] points = new CustomPoint[5];

        boolean full = true;
        while (full) {
            for (int i = 0; i < points.length; i++) {
                if (points[i] == null) {
                    points[i] = middle;
                    full = false;
                }
            }

            boolean goAgain = true;
            while (goAgain) {
                System.out.println("Which of your previous points do you want to delete from the history?");
                for (int i = 0; i < points.length; i++) {
                    System.out.println("Point " + (i + 1) + ": " + points[i]);
                }

                System.out.println("Enter point to delete (1, 2, 3, 4, or 5): ");
                int number = scan.nextInt();

                if (number <= 5 && number >= 1) {
                    points[number - 1] = middle;
                    goAgain = false;
                }
            }
        }
        return points;
    }

    // ligger 3 punkter på samma linje?
    // beräkna lutningen på linjen som går mellan två punkter
    // visa senaste 5 mittpunkterna (max 5 senaste)
        // Om ingen mittpunkt är angiven visa meddelande om det
    static void fiveLastPoints() {
        // Skapa en CustomPoint för att använda som "middle"
        CustomPoint middle = new CustomPoint(0.0, 0.0);

        // Anropa din arrayPoints-metod och skicka med "middle"
        CustomPoint[] pointsArray = arrayPoints(middle);

        // Skriv ut innehållet i arrayen
        System.out.println("Points in the array:");
        for (int i = 0; i < pointsArray.length; i++) {
            if (pointsArray[i] == null)
                    break;
            System.out.println("Point " + (i + 1) + ": " + pointsArray[i]);
        }
    }
}



