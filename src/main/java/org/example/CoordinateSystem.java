package org.example;

import java.awt.*;
import java.text.DecimalFormat;
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
        int choice = scan.nextInt();
            // Alt. 1 beräkna längd mellan två punkter
        if (choice == 1) {
            distance();
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
        }
    }
    // beräkna längd mellan två punkter
    static void distance() {
        var scan = new Scanner(System.in);

        System.out.print("Enter the x-coordinate for point 1: ");
        double x1 = scan.nextDouble();
        System.out.print("Enter the y-coordinate for point 1: ");
        double y1 = scan.nextDouble();

        System.out.print("Enter the x-coordinate for point 2: ");
        double x2 = scan.nextDouble();
        System.out.print("Enter the y-coordinate for point 2: ");
        double y2 = scan.nextDouble();

        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println("The distance between the two points is: " + decimalFormat.format(distance));
    }

    // få fram mittpunkten mellan två punkter, spara punkten i en fil
    static CustomPoint middlePoint () {
        var scan = new Scanner(System.in);
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
                e.printStackTrace();
            }
        }
// Om det redan finns 5 punkter, låt användaren välja vilken punkt i filen som ska ersättas
        if (points[4] != null) {
            System.out.println("The file already contains 5 points. Choose which point you want to replace: ");
            for (int i = 0; i < points.length; i++) {
                System.out.println("Point " + (i + 1) + ": " + points[i]);
            }
            System.out.print("Enter the number of the point you want to replace (1-5): ");
            int replaceIndex = scan.nextInt();
            if (replaceIndex >= 1 && replaceIndex <= 5) {
                points[replaceIndex - 1] = middle;
            } else {
                System.out.println("Invalid selection. No point replaced.");
            }
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
            e.printStackTrace();
        }

        return points;
    }

    // Visa senaste
        // Om ingen mittpunkt är angiven visa meddelande om det
    static List<CustomPoint> readPointsFromFile(String fileName) {
        List<CustomPoint> pointsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Anpassa hur strängen konverteras till CustomPoint
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                CustomPoint point = new CustomPoint(x, y);
                pointsList.add(point);
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(); // ev lägga till mer beskrivande felmeddelande
        }

        return pointsList;
    }
}



