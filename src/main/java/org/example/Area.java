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

    public static void main(String[] args, Scanner scan) {

        int shape = 0;
        // Kolla om inmatningen är giltig
        // Loopa tills att ett giltigt val väljs
        while (shape < 1 || shape > 4) {
            printMenu();

            while (!scan.hasNextInt()) {
                System.out.println("Error: Please enter a valid integer: ");
                scan.next(); // radera ogiltig inmatning
            }
            shape = scan.nextInt();

            // Visa felmeddelande om det valda numret är ogiltigt
            if (shape < 1 || shape > 4) {
                System.out.println("Error: Please enter a valid option (1-4): ");
            } else {
                // Beräkna arean på formen
                handleShapeInput(shape, scan);
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
    static double calculateCircleArea(Scanner scan) {
        double radius = getPositiveDoubleInput(scan, "Enter the radius: ");
        return circle(radius);
    }

    /**
     * Metod för att beräkna arean av en rektangel med inmatning.
     *
     * @return Arean av rektangeln.
     */
    static double calculateRectangleArea(Scanner scan) {
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

    /**
     * Metod för att beräkna arean av en triangel med inmatning.
     *
     * @return Arean av triangeln.
     */
    static double calculateTriangleArea(Scanner scan) {
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

    /**
     * Metod för att beräkna arean av en hexagon med inmatning.
     *
     * @return Arean av hexagonen.
     */
    static double calculateHexagonArea(Scanner scan) {
        double side = getPositiveDoubleInput(scan, "\n" + "Enter the length of the side: ");
        return hexagon(side);
    }

    /**
     * Read a positive double value from the user with the provided prompt using the given Scanner.
     *
     * @param scan   Scanner object to read input.
     * @param prompt Prompt to display to the user.
     * @return The positive double entered by the user.
     */
    static double getPositiveDoubleInput(Scanner scan, String prompt) {
        double value;
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
     * Handle the input for the chosen shape and display the calculated area.
     *
     * @param shape The chosen shape.
     * @param scan  Scanner object to read input.
     */
    static void handleShapeInput(int shape, Scanner scan) {
        double area = switch (shape) {
            case 1 -> calculateCircleArea(scan);
            case 2 -> calculateRectangleArea(scan);
            case 3 -> calculateTriangleArea(scan);
            case 4 -> calculateHexagonArea(scan);
            default -> 0.0; // Default value if the shape is not recognized
        };
        System.out.printf("The area of the selected shape is %.2f%n", area);
    }
}