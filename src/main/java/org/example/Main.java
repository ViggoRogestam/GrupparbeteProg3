package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int indata;
        ClearConsole clearConsole = new ClearConsole();
        while (true) {
            clearConsole.clearConsole();
            System.out.println("""
                     . .:: Coordinate System ::..

                    ------------------------------------------------------------

                    1. Calculate the length between two points
                    2. Convert between temperature units (Celsius, Farenheit & Kelvin)
                    3. Show the most recent midpoints (max 5 most recent)
                    4.
                    5. Convert between binary data sizes

                    ------------------------------------------------------------
                    >""");
            try {
                indata = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input");
                scan.next(); // clear the scanner buffer
                continue;
            }
            switch (indata) {
                case 1:
                    while (true) {
                        clearConsole.clearConsole();
                        //declare variables
                        double orgTemp;
                        String fromUnit, toUnit, anwser;
                        //ask user for input
                        try {
                            System.out.println("Enter temperature");
                            System.out.println("------------------------------------------------------------");
                            orgTemp = scan.nextDouble();
                            System.out.println("Enter temperature unit (celcsius, farneheit or kelvin)");
                            System.out.println("------------------------------------------------------------");
                            fromUnit = scan.next();
                            System.out.println("Enter unit to convert to (celcsius, farneheit or kelvin)");
                            System.out.println("------------------------------------------------------------");
                            toUnit = scan.next();
                            clearConsole.clearConsole();

                            //run convTemp class-method to convert temperature & print it out
                            System.out.println(orgTemp + " grader " + fromUnit + " är " + TemperatureUnits.convTemp(orgTemp, fromUnit, toUnit) + " " + toUnit);
                            System.out.println("------------------------------------------------------------");
                        } catch (Exception e) {
                            System.out.println("Invalid input" + e);
                            scan.nextLine(); // consume the next token, not the entire line
                        } finally {
                            System.out.println("\nDo you want to convert again (y/n)?");
                            System.out.println("------------------------------------------------------------");
                            anwser = scan.next();

                            //ask user if they want to continue the convertions or exit out of case 1
                            if (!Objects.equals(anwser, "y"))
                                break;
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        Area.main(null); // Call the Area module

                        // Create a new Scanner instance after the Area module
                        var scanner = new Scanner(System.in);

                        System.out.println("\nDo you want to convert again (y/n)?");
                        String answer = scanner.nextLine();

                        if (!answer.equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    var dataScanner = new Scanner(System.in);
                    while (true) {
                        // Clear Console by printing lines
                        clearConsole.clearConsole();
                        // Choose the unit to convert from
                        System.out.println("""
                                .: Which unit do you want to convert from?
                                ------------------------------------------
                                1. Byte
                                2. Kilobyte
                                3. Megabyte
                                4. Gigabyte
                                5. Terabyte
                                6. Exit
                                -------------------------------------------
                                """);

                        int fromInput = dataScanner.nextInt();
                        if (fromInput == 6) {
                            System.out.println("Exiting program.");
                            break; // Exit the loop
                        }

                        DataSizeConverter.DataUnit fromUnit = switch (fromInput) {
                            case 1 -> DataSizeConverter.DataUnit.BYTES;
                            case 2 -> DataSizeConverter.DataUnit.KILOBYTES;
                            case 3 -> DataSizeConverter.DataUnit.MEGABYTES;
                            case 4 -> DataSizeConverter.DataUnit.GIGABYTES;
                            case 5 -> DataSizeConverter.DataUnit.TERABYTES;
                            default -> null;
                        };

                        if (fromUnit == null) {
                            System.out.println("Invalid choice for source unit.");
                            continue; // Start the loop again
                        }

                        // Choose the unit to convert to
                        System.out.println("""
                                .: Which unit do you want to convert to?
                                ------------------------------------------
                                1. Byte
                                2. Kilobyte
                                3. Megabyte
                                4. Gigabyte
                                5. Terabyte
                                -------------------------------------------
                                """);

                        int toInput = dataScanner.nextInt();
                        DataSizeConverter.DataUnit toUnit = switch (toInput) {
                            case 1 -> DataSizeConverter.DataUnit.BYTES;
                            case 2 -> DataSizeConverter.DataUnit.KILOBYTES;
                            case 3 -> DataSizeConverter.DataUnit.MEGABYTES;
                            case 4 -> DataSizeConverter.DataUnit.GIGABYTES;
                            case 5 -> DataSizeConverter.DataUnit.TERABYTES;
                            default -> null;
                        };

                        if (toUnit == null) {
                            System.out.println("Invalid choice for target unit.");
                            continue; // Start the loop again
                        }

                        // Get the amount to convert
                        System.out.println("Enter the amount you wish to convert");
                        System.out.println("------------------------------------------------------------");
                        double amount = dataScanner.nextDouble();

                        // Perform the conversion
                        double convertedAmount = DataSizeConverter.convert(amount, fromUnit, toUnit);
                        System.out.println(amount + " " + fromUnit + " is " + convertedAmount + " " + toUnit + ".");
                    }
                    break;
                case 6:
                    lengthConverter.main(null);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}