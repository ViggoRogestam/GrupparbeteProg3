package org.example;

import java.util.Scanner;

public class Volume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Med hjälp av https://eddler.se/lektioner/volym/ för beräkningar

        do {
            System.out.println("Choose a figure:");
            System.out.println("1. Cube");
            System.out.println("2. Cuboid");
            System.out.println("3. Cylinder");
            System.out.println("4. Sphere");

            int option = scanner.nextInt();

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
                default:
                    System.out.println("Invalid option, try again.");
            }

            System.out.println("Do you want to calculate another volume? 1 = yes, 2 = no");
        } while (scanner.nextInt() == 1);

    }

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
