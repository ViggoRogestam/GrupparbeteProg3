package org.example;

import java.util.Scanner;

/**
 * Klass som hanterar menyvalet av de olika formerna som jag valt att använda,
 * har en klass per uträkning för att göra det lättare att läsa.
 * Tagit hjälp av https://eddler.se/lektioner/volym/ för alla beräkningar.
 * <hr>
 * Skapad av <b>Anton Lövgren</b>
 * <br>
 * Datum: 2024-01-13
 * Tid: 17:37
 * <br>
 * Projekt: GrupparbeteProg3
 * <br>
 * Upphovsrätt: MIT
 */

public class Volume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /**
         * Menyval för att välja vilken form man vill beräkna
         * <b>do</b>: är vad som händer
         * <b>while</b>: medans man skriver 1 är det true så då går den tillbaka till do
         *
         */
        do {
            System.out.println("Choose a figure:");
            System.out.println("1. Cube");
            System.out.println("2. Cuboid");
            System.out.println("3. Cylinder");
            System.out.println("4. Sphere");

            // Valet som int
            int option = scanner.nextInt();

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
                // Väljs varken 1-4 så är det invalid, då printar den det.
                default:
                    System.out.println("Invalid option, try again.");
            }

            System.out.println("Do you want to calculate another volume? 1 = yes, 2 = no");
        } while (scanner.nextInt() == 1);

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
