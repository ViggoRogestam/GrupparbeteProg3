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
        int shape = 0;

        // Loopa tills att ett giltigt val väljs
        while (shape < 1 || shape > 4) {
            printMenu();

            // Kolla om inmatningen är giltig
            try (Scanner scan = new Scanner(System.in)) {
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
                    handleShapeInput(shape);
                }
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
     * Metod för att beräkna arean av en cirkel med inmatning.
     *
     * @return Arean av cirkeln.
     */
    static double calculateCircleArea() {
        try (Scanner ignored = new Scanner(System.in)) {
            double radius = getPositiveDoubleInput( "Enter the radius: ");
            return circle(radius);
        }
    }

    /**
     * Metod för att beräkna arean av en rektangel med inmatning.
     *
     * @return Arean av rektangeln.
     */
    static double calculateRectangleArea() {
        try (Scanner scan = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.print("Enter the width and height (Width Height): ");

            double width = 0;
            double height = 0;

            // Ensure that both width and height are provided
            while (width <= 0 || height <= 0) {
                try {
                    // Read the width and height
                    width = scan.nextDouble();
                    height = scan.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.print("Error: Please enter valid numbers for width and height (Width Height): ");
                    scan.nextLine(); // Clear the invalid input
                    continue;
                } catch (NoSuchElementException e) {
                    System.out.println("Error: End of input reached unexpectedly.");
                    return 0.0; // Return 0.0 if end of input is reached unexpectedly.
                }
                // Check if the values are positive
                if (width <= 0 || height <= 0) {
                    System.out.println("Error: Enter positive values for width and height.");
                }
            }


            return rectangle(height, width);
        }
    }


    /**
     * Metod för att beräkna arean av en triangel med inmatning.
     *
     * @return Arean av triangeln.
     */
    static double calculateTriangleArea() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the base and height (Base Height): ");

            double base = 0;
            double height = 0;

            // Ensure that both width and height are provided
            while (base <= 0 || height <= 0) {
                try {
                    // Read the width and height
                    base = scan.nextDouble();
                    height = scan.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.print("Error: Please enter valid numbers for base and height (Width Height): ");
                    scan.nextLine(); // Clear the invalid input
                    continue;
                } catch (NoSuchElementException e) {
                    System.out.println("Error: End of input reached unexpectedly.");
                    return 0.0; // Return 0.0 if end of input is reached unexpectedly.
                }
                // Check if the values are positive
                if (base <= 0 || height <= 0) {
                    System.out.println("Error: Enter positive values for base and height.");
                }
            }


            return triangle(height, base);
        }
    }
    /**
     * Metod för att beräkna arean av en hexagon med inmatning.
     *
     * @return Arean av hexagonen.
     */
    static double calculateHexagonArea() {
        try (Scanner ignored = new Scanner(System.in)) {
            double side = getPositiveDoubleInput( "\n" + "Enter the length of the side: ");
            return hexagon(side);
        }
    }

    static double getPositiveDoubleInput(String prompt) {
        double value;
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        do {
            System.out.print(prompt);
            while (!scan.hasNextDouble()) {
                System.out.print("Error: Please enter a valid number: ");
                scan.next(); // Delete invalid input
            }
            value = scan.nextDouble();
            if (value <= 0) {
                System.out.println("Error: Enter a positive value.");
            }
        } while (value <= 0);

            scan.close();

        return value;
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
     * @param shape Vald form.
     */
    static void handleShapeInput(int shape) {
        // Använd switch-sats för att välja rätt beräkningsmetod baserat på vald form
        double area = switch (shape) {
            case 1 -> calculateCircleArea();
            case 2 -> calculateRectangleArea();
            case 3 -> calculateTriangleArea();
            case 4 -> calculateHexagonArea();
            default -> 0.0; // Standardvärde om formen inte känns igen
        };
        // Visa resultatet av den beräknade arean för den valda formen
        System.out.printf("The area of the selected shape is %.2f", area);
    }
}