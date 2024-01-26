/**
 * Created by: Aria Hussein
 * Date: 2024-01-12
 * Time: 15:00
 * Project: GrupparbeteProg3
 * Copyright: MIT
 */
package org.example;
import java.util.Scanner;

public class lengthConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * Startas en loop som inte tar slut tills man skriver exit.
         * kräver args:
         * Length: int
         * Unit: String
         */
        while (true) {
            System.out.println("""
                 ..:: Length Converter ::..
                
                ------------------------------------------------------------

                Enter length and unit
                Enter \"exit\" if you want to return to main menu
                
                
                Unit to choose betweeen:
                1. millimeter
                2. centimeter
                3. meter
                4. kilometer
                5. inches
                6. feet
                ------------------------------------------------------------
                """);
            String lengthInput = scanner.nextLine();


            // Avslutar och går tillbaka till main
            if (lengthInput.equals("exit")) {
                Main.main(null);
            }
            // Plockar isär lengthinput string och skapar 2 olika variabel, längd och sedan unit för att kunna konvertera
            String[] lengthParts = lengthInput.split("\\s+");
            if (lengthParts.length != 2) {
                System.out.println("Error: Enter valid length and unit.");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                continue;
            }

            String valueStr = lengthParts[0];
            String unit = lengthParts[1];


            // Val utav vilken unit man vill konvertera till
            try {
                double value = Double.parseDouble(valueStr);
                Length l1 = new Length(value, unit);

                System.out.println("Choose unit to convert to");
                System.out.println("1. Millimeter\n2. Centimeter\n3. Meter\n4. Kilometer\n5. Inches\n6. Feet");
                System.out.print("> ");
                String choice = scanner.nextLine();

                if (unit.matches("millimeter|centimeter|meter|kilometer|inches|feet")) {
                    switch (choice) {
                        case "1":
                            System.out.println(lengthInput + " equals " + formatDecimal(l1.toMillimeter()) + " millimeter");
                            break;
                        case "2":
                            System.out.println(lengthInput + " equals " + formatDecimal(l1.toCentimeter()) + " centimeter");
                            break;
                        case "3":
                            System.out.println(lengthInput + " equals " + formatDecimal(l1.toMeter()) + " meter");
                            break;
                        case "4":
                            System.out.println(lengthInput + " equals " + formatDecimal(l1.toKilometer()) + " kilometer");
                            break;
                        case "5":
                            System.out.println(lengthInput + " equals " + formatDecimal(l1.toInches()) + " inches");
                            break;
                        case "6":
                            System.out.println(lengthInput + " equals " + formatDecimal(l1.toFeet()) + " feet");
                            break;
                        default:
                            System.out.println("Error: Invalid input.");
                    }
                    System.out.println("Press Enter to continue");
                    scanner.nextLine();
                } else {
                    System.out.println("Error: " + unit + " is not valid");
                    System.out.println("Press Enter to continue");
                    scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("ValueError: Enter valid length and unit.");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
            }
        }
    }

    // för att undvika skriva ut massa decimaler.
    private static String formatDecimal(double value) {
        return String.format("%.5f", value);
    }
}


