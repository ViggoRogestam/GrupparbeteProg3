/**
 * Created by: Aria Hussein
 * Date: 2024-01-12
 * Time: 15:01
 * Project: GrupparbeteProg3
 * Copyright: MIT
 */
import java.util.Scanner;

public class lengthConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Length Converter");

        while (true) {
            System.out.print("Enter length and unit > ");
            String lengthInput = scanner.nextLine();

            String[] lengthParts = lengthInput.split("\\s+");
            if (lengthParts.length != 2) {
                System.out.println("Error: Enter valid length and unit.");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                continue;
            }

            String valueStr = lengthParts[0];
            String unit = lengthParts[1];

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
    private static String formatDecimal(double value) {
        return String.format("%.3f", value);
    }
}