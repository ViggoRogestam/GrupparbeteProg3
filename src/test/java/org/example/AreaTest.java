package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by Lina Romilson
 * Date: 2024-01-12
 * Time: 13:41
 * Project GrupparbeteProg3
 * Copyright: MIT
 */
public class AreaTest {
    @Test
    void testCircle() {
        // Definiera en liten felmarginal för jämförelsen av double-värden
        double delta = 0.0001;

        // Testa metoden med olika radier
        assertEquals(0.0, Area.circle(0), delta);  // Förväntat resultat: 0 för en cirkel med radie 0
        assertEquals(Math.PI, Area.circle(1), delta);  // Förväntat resultat: π för en cirkel med radie 1
        assertEquals(4 * Math.PI, Area.circle(2), delta);  // Förväntat resultat: 4π för en cirkel med radie 2
        assertEquals(25 * Math.PI, Area.circle(5), delta);  // Förväntat resultat: 25π för en cirkel med radie 5
    }

    @Test
    void testRectangle() {
        // Definiera en liten felmarginal för jämförelsen av double-värden
        double delta = 0.0001;

        // Testa metoden med olika höjder och bredder
        assertEquals(0.0, Area.rectangle(0, 10), delta);  // Förväntat resultat: 0 för en rektangel med höjd 0 och bredd 10
        assertEquals(0.0, Area.rectangle(5, 0), delta);  // Förväntat resultat: 0 för en rektangel med höjd 5 och bredd 0
        assertEquals(15.0, Area.rectangle(3, 5), delta);  // Förväntat resultat: 3 * 5 = 15 för en rektangel med höjd 3 och bredd 5
        assertEquals(25.0, Area.rectangle(5, 5), delta);  // Förväntat resultat: 5 * 5 = 25 för en rektangel med höjd 5 och bredd 5
    }

    @Test
    void testTriangle() {
        // Definiera en liten felmarginal för jämförelsen av double-värden
        double delta = 0.0001;

        // Testa metoden med olika höjder och baser
        assertEquals(7.7, Area.triangle(7, 2.2), delta);  // Förväntat resultat: 7.7 för en triangel med höjd 7 och bas 2.2
        assertEquals(44.07, Area.triangle(3.9, 22.6), delta);  // Förväntat resultat: 44.07 för en triangel med höjd 3.9 och bas 22.6
        assertEquals(7.5, Area.triangle(3, 5), delta);  // Förväntat resultat: 7.5 för en triangel med höjd 3 och bas 5
        assertEquals(12.5, Area.triangle(5, 5), delta);  // Förväntat resultat: 12.5 för en triangel med höjd 5 och bas 5
    }

    @Test
    void testHexagon() {
        // Definiera en liten felmarginal för jämförelsen av double-värden
        double delta = 0.001;

        // Testa metoden med olika sidor av hexagonen
        assertEquals(10.392, Area.hexagon(2), delta);  // Förväntat resultat: 10.392 för en hexagon med sidlängd 2
        assertEquals(2.598, Area.hexagon(1), delta);  // Förväntat resultat: 2.598 för en hexagon med sidlängd 1
        assertEquals(41.569, Area.hexagon(4), delta);  // Förväntat resultat: 41.569 för en hexagon med sidlängd 4
        assertEquals(78.591, Area.hexagon(5.5), delta);  // Förväntat resultat: 78.591 för en hexagon med sidlängd 5.5
    }
    @Test
    void testCalculateCircleArea() {
        System.setIn(new ByteArrayInputStream("3\n".getBytes())); // Simulate user input
        double result = Area.calculateCircleArea();
        assertEquals(28.274, result, 0.001);
    }
    @Test
    void testCalculateRectangleArea() {

        System.setIn(new ByteArrayInputStream("2.5\n3.7\n".getBytes())); // Simulate user input
        double result = Area.calculateRectangleArea();

        // Testa metoden med olika höjder och baser
        assertEquals(9.25, result,0.0001);
    }
    @Test
    void testCalculateTriangleArea() {
        System.setIn(new ByteArrayInputStream("5\n6\n".getBytes())); // Simulate user input
        double result = Area.calculateTriangleArea();

        // Testa metoden med olika höjder och baser
        assertEquals(15, result,0.0001);
    }
    @Test
    void testCalculateHexagonArea() {
        System.setIn(new ByteArrayInputStream("3\n".getBytes())); // Simulate user input
        double result = Area.calculateHexagonArea();

        // Testa metoden med olika sidor av hexagonen
        assertEquals(23.382, result,0.001);
    }
    @Test
    void testGetPositiveDoubleInput() {
        // Set up the mock input
        String input = "-1\n0\nabc\n5.5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Execute the method and capture output
        double result = Area.getPositiveDoubleInput("Enter a positive number: ");

        // Assert the result
        assertEquals(5.5, result, 0.0001);
    }
    @Test
    void testPrintMenu() {
        // Prepare to capture System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method
        Area.printMenu();

        // Reset System.out
        System.setOut(System.out);

        // Define the expected output
        String expectedOutput = ("..:: Area converter ::.." + """
                                
            ------------------------
            1. Circle \t\t\t\t| \u25CB
            2. Rectangle \t\t\t| \u25AD
            3. Triangle \t\t\t| \u25B3
            4. Equilateral hexagon \t| \u2B21
            ------------------------
            Choose a shape:""" + " ");

        // Check if the captured output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }
    @Test
    void testHandleShapeInput() {
        // Använd en ByteArrayInputStream för att simulera användarinput
        String input = "3\n"; // Använd 3 för att testa calculateTriangleArea
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Anropa metoden handleShapeInput och fånga upp utmatningen (System.out)
        String output = TestUtils.captureSystemOut(() -> Area.handleShapeInput(3));

        // Kontrollera att utmatningen innehåller förväntad text
        assertTrue(output.contains("Enter the base and height (Base Height):"));
        assertTrue(output.contains("Error: End of input reached unexpectedly."));
        assertTrue(output.contains("The area of the selected shape is 0,00"));
    }
}