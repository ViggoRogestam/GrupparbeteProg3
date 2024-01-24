package org.example;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lina Romilson
 * Date: 2024-01-15
 * Time: 14:10
 * Project GrupparbeteProg3
 * Copyright: MIT
 */
public class CoordinateSystem {
    public static void main(String[] args) {
        String pointsFile = "points.txt";
        List<CustomPoint> points = readPointsFromFile(pointsFile);
        // Skapa meny med if-else sats för att kunna välja vilket av alternativen man vill utföra
        System.out.println("""
                 ..:: Coordinate System ::..
                
                ------------------------------------------------------------

                1. Calculate the length between two points
                2. Find the midpoint between two points
                3. Show the most recent midpoints (max 5 most recent)
                
                ------------------------------------------------------------""");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option from the menu: ");

            try {
                int choice = scan.nextInt();

                if (choice == 1) {
                    System.out.print("Enter the x-coordinate for point 1: ");
                    double x1 = getDoubleInput(scan, scan.nextLine());
                    System.out.print("Enter the y-coordinate for point 1: ");
                    double y1 = getDoubleInput(scan, scan.nextLine());

                    System.out.print("Enter the x-coordinate for point 2: ");
                    double x2 = getDoubleInput(scan, scan.nextLine());
                    System.out.print("Enter the y-coordinate for point 2: ");
                    double y2 = getDoubleInput(scan, scan.nextLine());
                    distance(x1, y1, x2, y2);
                    break;
                }

                // Alt. 2 få fram mittpunkten mellan två punkter (spara punkten i en array?)
                else if (choice == 2) {
                    CustomPoint middle = middlePoint();
                    System.out.println("The midpoint is: " + middle);
                    arrayPoints(middle);
                    System.out.println();
                    break;
                }
                // Alt. 3 visa senaste 5 mittpunkterna (max 5 senaste)
                // Om ingen mittpunkt är angiven visa meddelande om det
                else if (choice == 3) {
                    // Kontrollera om listan av CustomPoint är tom
                    if (points.isEmpty()) {
                        System.out.println("There is no midpoints stored");
                    } else {
                        // Annars, använd listan av CustomPoint från filen
                        for (CustomPoint point : points) {
                            System.out.println(point);
                        }
                    }
                    break;
                }
                else
                    System.out.println("Enter a valid choice (1-3)");
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scan.nextLine(); // Clear the scanner buffer
            }
        }
    }
            // Alt. 1 beräkna längd mellan två punkter


    // har denna som static double och inte void för att kunna spara längden
    // i fil, likt mittpunkten
    /**
     * Beräknar längden mellan två punkter
     *
     * @return längden
     */
    static double distance(double x1, double y1, double x2, double y2) {
        // Calculate the distance between the two points
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        // Print the distance formatted to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("The distance between the two points is: " + decimalFormat.format(distance));
        return distance;
    }

    /**
     * Får fram mittpunkten mellan två punkter
     * @return mittpunkt
     */
    static CustomPoint middlePoint () {
        var scan = new Scanner(System.in);
        System.out.print("Enter the x-coordinate for point 1: ");
        while (!scan.hasNextDouble()) {
            String input = scan.next();
            System.out.println("Invalid input: " + input + ". Please enter a valid number: ");
        }
        double x1 = scan.nextDouble();
        System.out.print("Enter the y-coordinate for point 1: ");
        while (!scan.hasNextDouble()) {
            String input = scan.next();
            System.out.println("Invalid input: " + input + ". Please enter a valid number: ");
        }
        double y1 = scan.nextDouble();
        System.out.print("Enter the x-coordinate for point 2: ");
        while (!scan.hasNextDouble()) {
            String input = scan.next();
            System.out.println("Invalid input: " + input + ". Please enter a valid number: ");
        }
        double x2 = scan.nextDouble();
        System.out.print("Enter the y-coordinate for point 2: ");
        while (!scan.hasNextDouble()) {
            String input = scan.next();
            System.out.println("Invalid input: " + input + ". Please enter a valid number: ");
        }
        double y2 = scan.nextDouble();

        double middleX = (x1 + x2) / 2;
        double middleY = (y1 + y2) / 2;
        return new CustomPoint(middleX, middleY);

    }

    /**
     * Läser, uppdaterar och sparar punkter i points.txt
     * @param middle CustomPoint som representerar mittpunkten som läggs till
     * @return Array av punkter med de uppdaterade punkterna
     */
    static CustomPoint[] arrayPoints(CustomPoint middle) {
        Scanner scan = new Scanner(System.in);
        CustomPoint[] points = new CustomPoint[5];

        // Läs in data från filen (om filen finns)
        File file = new File("points.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                for (int i = 0; i < points.length; i++) {
                    String line = br.readLine();
                    if (line != null) {
                        // Anpassa hur strängen konverteras till CustomPoint
                        String[] parts = line.split(",");
                        double x = Double.parseDouble(parts[0]);
                        double y = Double.parseDouble(parts[1]);
                        points[i] = new CustomPoint(x, y);
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
// Om det redan finns 5 punkter, låt användaren välja vilken punkt i filen som ska ersättas
        if (points[4] != null) {
            System.out.println("The file already contains 5 points. Choose which point you want to replace: ");
            for (int i = 0; i < points.length; i++) {
                System.out.println("Point " + (i + 1) + ": " + points[i]);
            }
            int replaceIndex;
            do {
                System.out.print("Enter the number of the point you want to replace (1-5): ");
                while (!scan.hasNextInt()) {
                    String input = scan.next();
                    System.out.println("Invalid input: " + input + ". Please enter an integer between 1 and 5: ");
                }
                replaceIndex = scan.nextInt();
            } while (replaceIndex < 1 || replaceIndex > 5);

            points[replaceIndex -1] = middle;
        } else {
            // Om det inte finns 5 punkter, lägg till den nya mittpunkten
            for (int i = 0; i < points.length; i++) {
                if (points[i] == null) {
                    points[i] = middle;
                    break;
                }
            }
        }


        // Spara data till filen points.txt
        try (FileWriter writer = new FileWriter(file)) {
            for (CustomPoint point : points) {
                // Anpassa hur CustomPoint skrivs till filen
                if (point != null) {
                    writer.write(point.getX() + "," + point.getY() + "\n");
                }            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading/writing: " + e.getMessage());
        }

        return points;
    }

    /**
     * Läser in CustomPoint-objekt från textfilen points.txt.
     *
     * @param fileName Namnet på filen som innehåller CustomPoint-data.
     * @return En lista med CustomPoint-objekt som lästs in från points.txt.
     */
    static List<CustomPoint> readPointsFromFile(String fileName) {
        // Skapa en lista för att lagra CustomPoint-objekt
        List<CustomPoint> pointsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Läs varje rad från filen
            while ((line = br.readLine()) != null) {
                // Anpassa hur strängen konverteras till CustomPoint
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                CustomPoint point = new CustomPoint(x, y);
                // Lägg till CustomPoint-objektet i listan
                pointsList.add(point);
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Ett fel inträffade vid läsning/skrivning: " + e.getMessage());
        }

        return pointsList;
    }
    /**
     * Read a double value from the user with the provided prompt using the given Scanner.
     *
     * @param scan   Scanner object to read input.
     * @param prompt Prompt to display to the user.
     * @return The double entered by the user.
     */
    static double getDoubleInput(Scanner scan, String prompt) {
        double value;

        System.out.print(prompt);
        while (!scan.hasNextDouble()) {
            System.out.print("Error: Please enter a valid number: ");
            scan.next(); // Delete invalid input
        }
        value = scan.nextDouble();

        return value;
    }
}



