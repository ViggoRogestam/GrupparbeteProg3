package org.example;
import java.util.*;

/**
 * Klass för att beräkna arean på formerna cirkel, rektangel,
 * triangel och liksidig hexagon. Användaren väljer en
 * form och anger nödvändiga parametrar, klassen beräknar och
 * visar arean.

 * Skapad av Lina Romilson
 * Datum: 2024-01-10
 * Tid: 13:36
 * Projekt: GrupparbeteProg3
 * Upphovsrätt: MIT
 */
public class Area {

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int shape = 0;

        // Loopa tills att ett giltigt val väljs
        while (shape < 1 || shape > 4) {
            printMenu();

            // Kolla om inmatningen är giltig
            while (!scan.hasNextInt()) {
                System.out.print("Error: Please enter a valid integer: ");
                scan.next(); // radera ogiltig inmatning
            }
            shape = scan.nextInt();

            // Visa felmeddelande om det valda numret är ogiltigt
            if (shape < 1 || shape > 4) {
                System.out.print("Error: Please enter a valid option (1-4): ");
            } else {
                // Beräkna arean på formen
                handleShapeInput(scan, shape);
            }
        }
    }

    // Metoder för att beräkna arean av olika former

    /**
     * Metod för att beräkna arean av en cirkel.
     * @param r Radien för cirkeln.
     * @return Arean av cirkeln.
     */
    static double circle(double r) {
        return Math.pow(r,2) * Math.PI;
    }

    /**
     * Metod för att beräkna arean av en rektangel.
     * @param h Höjden på rektangeln.
     * @param b Basen på rektangeln.
     * @return Arean av rektangeln.
     */
    static double rectangle(double h, double b) {
        return h * b;
    }

    /**
     * Metod för att beräkna arean av en triangel.
     * @param h Höjden på triangeln.
     * @param b Basen på triangeln.
     * @return Arean av triangeln.
     */
    static double triangle(double h, double b) {
        return (h * b) / 2;
    }

    /**
     * Metod för att beräkna arean av en liksidig hexagon.
     * @param s Längden på en sida av hexagonen.
     * @return Arean av hexagonen.
     */
    static double hexagon(double s) {
        return (3 * Math.sqrt(3) * Math.pow(s, 2)) / 2;
    }

    /**
     * Metod för att hämta icke-negativt från användaren.
     * @param scan   Scanner-objekt för inmatning.
     * @param prompt Meddelande för användaren.
     * @return Icke-negativt tal från användaren.
     */
    static double getNonNegativeDoubleInput(Scanner scan, String prompt) {
        double value;
        do {
            System.out.print(prompt);
            while (!scan.hasNextDouble()) {
                System.out.print("Error: Please enter a valid number: ");
                scan.next(); // Radera ogiltig inmatning
            }
            value = scan.nextDouble();
            if (value < 0) {
                System.out.println("Error: Enter a non-negative value.");
            }
        } while (value < 0);
        return value;
    }

    /**
     * Metod för att beräkna arean av en cirkel med inmatning.
     *
     * @param scan Scanner-objekt för inmatning.
     * @return Arean av cirkeln.
     */
    static double calculateCircleArea(Scanner scan) {
        double radius = getNonNegativeDoubleInput(scan, "Enter the radius: ");
        return circle(radius);
    }

    /**
     * Metod för att beräkna arean av en rektangel med inmatning.
     * @param scan Scanner-objekt för inmatning.
     * @return Arean av rektangeln.
     */
    static double calculateRectangleArea(Scanner scan) {
        double width = getNonNegativeDoubleInput(scan, "Enter the width: ");
        double height = getNonNegativeDoubleInput(scan, "Enter the height: ");
        return rectangle(height, width);
    }

    /**
     * Metod för att beräkna arean av en triangel med inmatning.
     * @param scan Scanner-objekt för inmatning.
     * @return Arean av triangeln.
     */
    static double calculateTriangleArea(Scanner scan) {
        double height = getNonNegativeDoubleInput(scan, "Enter the height: ");
        double base = getNonNegativeDoubleInput(scan, "Enter the base: ");
        return triangle(height, base);
    }

    /**
     * Metod för att beräkna arean av en hexagon med inmatning.
     * @param scan Scanner-objekt för inmatning.
     * @return Arean av hexagonen.
     */
    static double calculateHexagonArea(Scanner scan) {
        double side = getNonNegativeDoubleInput(scan, "\n" + "Enter the length of the side: ");
        return hexagon(side);
    }

    /**
     * Metod för att skriva ut menyn för att välja en form.
     */
    static void printMenu() {
        System.out.print("..:: Area converter ::.." + """
                                
            ------------------------
            1. Circle \t\t\t\t| \u25CB
            2. Rectangle \t\t\t| \u25AD
            3. Triangle \t\t\t| \u25B3
            4. Equilateral hexagon \t| \u2B21
            ------------------------
            Choose a shape:""" + " ");
    }

    /**
     * Metod för att hantera inputen för den valda formen och visa den beräknade arean.
     * @param scan  Scanner-objekt för inmatning.
     * @param shape Vald form.
     */
    static void handleShapeInput(Scanner scan, int shape) {
        // Använd switch-sats för att välja rätt beräkningsmetod baserat på vald form
        double area = switch (shape) {
            case 1 -> calculateCircleArea(scan);
            case 2 -> calculateRectangleArea(scan);
            case 3 -> calculateTriangleArea(scan);
            case 4 -> calculateHexagonArea(scan);
            default -> 0.0; // Standardvärde om formen inte känns igen
        };

        // Visa resultatet av den beräknade arean för den valda formen
        System.out.printf("The area of the selected shape is %.2f", area);
    }
}