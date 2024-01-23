package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klass som hanterar menyvalet av de olika formerna som jag valt att använda,
 * har en klass per uträkning för att göra det lättare att läsa.
 * Tagit hjälp av https://eddler.se/lektioner/volym/ för alla beräkningar.
 * <hr>
 *
 * @author Anton Lövgren
 * <br>
 * Datum: 2024-01-13
 * Tid: 17:37
 * <br>
 * Projekt: <a href="https://github.com/ViggoRogestam/GrupparbeteProg3/">GrupparbeteProg3</a>
 * <br>
 * Upphovsrätt: MIT
 */

public class Volume {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /**
         * Menyval för att välja vilken form man vill beräkna
         * <b>do</b>: är vad som händer
         * <b>while</b>: medans man skriver 1 är det true så då går den tillbaka till do
         */
        int continueOption;
        do {
            System.out.println("""
                     ..:: Volume Calculator ::..
                                    
                    ------------------------------------------------------------
                                    
                    What figure do you want to calculate the volume of?
                    1. Cube
                    2. Cuboid
                    3. Cylinder
                    4. Sphere
                                    
                    5. Exit to the main menu
                                    
                    ------------------------------------------------------------""");

            int option = 0;

            // Felhantering
            while (true) {
                try {
                    option = scan.nextInt();
                    break; // Om inläsningen är lyckad, bryt ut ur loopen
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input");
                    scan.next(); // Rensa scanner bufferten från felaktig inmatning
                    System.out.println("Enter a correct option between 1 and 5");
                }
            }

            // Switch för att ändra till den metoden man väljer
            switch (option) {
                case 1:
                    calculateCube();
                    break;
                case 2:
                    calculateCuboid();
                    break;
                case 3:
                    calculateCylinder();
                    break;
                case 4:
                    calculateSphere();
                    break;
                case 5:
                    Main.main(null);
                    break;
                // Väljs varken 1-4 så är det invalid, då printar den det.
                default:
                    System.out.println("Invalid option, try again.");
            }

            continueOption = 0;
            while (true) {
                try {
                    System.out.println("Do you want to calculate another volume? 1 = yes, 2 = no");
                    continueOption = scan.nextInt();
                    if (continueOption == 1 || continueOption == 2) {
                        break;
                    } else {
                        System.out.println("Invalid option, enter 1 for yes or 2 for no");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input");
                    scan.next();
                }
            }
        } while (continueOption == 1);
    }

    // Alla metoder för att kalla på de andra metoderna som finns i andra klasser.
    private static void calculateCube() {
        Cube.main(null);
    }

    private static void calculateCuboid() {
        Cuboid.main(null);
    }

    private static void calculateCylinder() {
        Cylinder.main(null);
    }

    private static void calculateSphere() {
        Sphere.main(null);
    }
}
