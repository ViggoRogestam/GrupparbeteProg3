package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try (Scanner scan = new Scanner(System.in)) {
            int indata;
            ClearConsole clearConsole = new ClearConsole();

            outerLoop: while (true) {
                System.out.println("""
                         . .:: Converter ::..
                                        
                        ------------------------------------------------------------
                            
                        1. Temperature
                        2. Area
                        3. Coordinate system
                        4. Volume
                        5. Datatype
                        6. Length
                        7. Exit
                                        
                        ------------------------------------------------------------""");
                while (true) {
                    try {
                        indata = scan.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input");
                        scan.next(); // clear the scanner buffer
                    }
                }
                if (indata == 7)
                    System.exit(0);
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
                                  continue outerLoop;
                          }
                      }

                    case 2:
                        while (true) {
                            // Call the main method of the Area class
                            Area.main(args, scan);
                            scan.nextLine();
                            // Ask the user if they want to run the program again
                            System.out.print("\nDo you want to run the program again? (y/n) (close the program with x): ");
                            String userInput = scan.nextLine();
                            // If the user enters anything other than 'y', exit the loop
                            if (!userInput.equalsIgnoreCase("y")) {
                                continue outerLoop;
                            }
                        }
                    case 3:
                        while (true) {
                            // Call the main method of the CoordinateSystem class
                            CoordinateSystem.main(args);

                            // Ask the user if they want to run the program again
                            System.out.print("Do you want to run the program again? (y/n): ");
                            String input = scan.next();

                            // If the user enters anything other than 'y', exit the loop
                            if (!input.equalsIgnoreCase("y")) {
                                continue outerLoop;
                            }
                        }
                    case 4:
                        Volume.main(null);
                        continue outerLoop;
                    case 5:
                    var dataScanner = new Scanner(System.in);
                    while (true) {
                        // Clear Console by printing lines
                        //clearConsole.clearConsole();
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
                            continue outerLoop; // Exit the loop
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
                    case 6:
                        lengthConverter.main(null);
                        continue outerLoop;
                    default:
                            System.out.println("Invalid input");

                    }


            }
        }
    }
}

// class main
// public static void

//loop that runs the program

//if-statments to choose which converter to use (area, volumes etc.)

//when choosen run a loop inside the loop that runs an imported method with the code to run the calculation

//print result and ask user if they want to run the method again or
//go back to the main loop and choose another calculation