package org.example;

import java.util.*;

/**
 * Created by Lina Romilson
 * Date: 2024-01-10
 * Time: 13:36
 * Project GrupparbeteProg3
 * Copyright: MIT
 */
public class Area {

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.print("..:: Area converter ::.." + """
                                
                ------------------------
                1. Circle \t\t\t\t| \u25CB
                2. Rectangle \t\t\t| \u25AD
                3. Triangle \t\t\t| \u25B3
                4. Equilateral hexagon \t| \u2B21
                ------------------------
                Choose a shape:""" + " ");
        int shape = scan.nextInt();

        // 1. If-else sats för att välja vilken form arean ska räknas ut på
            // 1.1 Kör i igen vid felaktigt angivet val
        boolean tryAgain = true;
        while (tryAgain) {
            if (shape <= 4 && shape >= 1) {
                // 2. Cirkel
                if (shape == 1) {
                    // 2.1 Ange radien
                    System.out.print("Enter the radius: ");
                    double radius = scan.nextDouble();
                    // 2.1.1 Använd metoden circle
                    double area = circle(radius);
                    // 2.2 Visa resultatet
                    System.out.printf("The area of the circle is " + "%.2f\n", area);
                    // 2.3 Ändra tryAgain till false
                    tryAgain = false;
                }
                // 3. Rektangel
                else if (shape == 2) {
                    // 3.1 Ange sidornas längd
                    System.out.print("Enter the width: ");
                    double b = scan.nextDouble();
                    System.out.print("Enter the height: ");
                    double h = scan.nextDouble();
                    // 3.1.1 Använd metoden rectangle
                    double area = rectangle(h,b);
                    // 3.2 Visa resultatet
                    System.out.printf("The area of the rectangle is " + "%.2f\n", area);
                    // 3.3 Ändra tryAgain till false
                    tryAgain = false;
                }
                // 4. Triangel
                else if (shape == 3) {
                    // 4.1 Ange höjd och bas
                    System.out.print("Enter the height: ");
                    double h = scan.nextDouble();
                    System.out.print("Enter the base: ");
                    double b = scan.nextDouble();
                    // 4.1.1 Använd metoden triangle
                    double area = triangle(h, b);
                    // 4.2 Visa resultatet
                    System.out.printf("The area of the triangle is " + "%.2f\n", area);
                    // 4.3 Ändra tryAgain till false
                    tryAgain = false;
                }
                // 5. Hexagon
                else {
                    // 5.1 Ange sidans längd
                    System.out.print("Enter the length of the side: ");
                    double s = scan.nextDouble();
                    // 5.1.1 Använd metoden hexagon
                    double area = hexagon(s);
                    // 5.2 Visa resultatet
                    System.out.printf("the area of the hexagon is " + "%.2f\n", area);
                    // 5.3 Ändra tryAgain till false
                    tryAgain = false;
                }
            }
            else {
                System.out.print("Fel: ange ett giltigt alternativ: ");
                shape = scan.nextInt();
            }
        }
    }
    // Skapa metoder för formerna

    /**
     * Metod som räknar ut cireklns area
     * @param r anger cirkelns radie
     * @return cirkelns area
     */
    static double circle (double r) {
        return Math.sqrt(r) * Math.PI;
    }

    /**
     * Metod som räknar ut rektangelns area
     * @param h anger rektangelns höjd
     * @param b anger rektangelns bredd
     * @return rektangelns area
     */
    static double rectangle (double h, double b) {
        return h * b;
    }

    /**
     * Metod som räknar ut rektangelns area
     * @param h anger triangelns höjd
     * @param b anger triangelns bas
     * @return triangelns area
     */
    static double triangle (double h, double b) {
        return (h*b)/2;
    }

    /**
     * Metod som räknar ut arean på en liksidig hexagon
     * @param s anger längden på hexagonens sida
     * @return hexagonens area
     */
    static double hexagon (double s) {
        return (3*Math.sqrt(3) * Math.pow(s,2))/2;
    }
}
