package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Lina Romilson
 * Date: 2024-01-18
 * Time: 09:35
 * Project GrupparbeteProg3
 * Copyright: MIT
 */
class CoordinateSystemTest {
    @Test
    public void testDistance1() {
        double expectedDistance = Math.sqrt(Math.pow(4 - 2, 2) + Math.pow(5 - 3, 2));
        double actualDistance = CoordinateSystem.distance(2, 3, 4, 5);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }
    @Test
    public void testDistance2() {
        double expectedDistance = Math.sqrt(Math.pow(-1 - 0, 2) + Math.pow(-2 - 0, 2));
        double actualDistance = CoordinateSystem.distance(-1, -2, 0, 0);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }
    @Test
    public void testDistance3() {
        double expectedDistance = Math.sqrt(Math.pow(3.1415 - 6.2831, 2) + Math.pow(6.2831 - 3.1415, 2));
        double actualDistance = CoordinateSystem.distance(3.1415, 6.2831, 6.2831, 3.1415);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }
    @Test
    public void testDistance4() {
        double expectedDistance = 0;
        double actualDistance = CoordinateSystem.distance(0, 0, 0, 0);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }
    @Test
    public void testGetMiddlePoint() {
        System.setIn(new ByteArrayInputStream("3\n4\n5\n6\n".getBytes())); // Simulate user input
        CustomPoint actualMiddlePoint = CoordinateSystem.middlePoint();
        String actualMiddlePointString = actualMiddlePoint.toString();
        CustomPoint expectedMiddlePoint = new CustomPoint(4,5);
        String expectedMiddlePointString = expectedMiddlePoint.toString();
        assertEquals(expectedMiddlePointString,actualMiddlePointString);
    }

    @Test
    void testArrayPointsWithExistingPoints() {
        CustomPoint middle = new CustomPoint(0.0, 0.0);
        CustomPoint[] expectedPoints = new CustomPoint[] {
                new CustomPoint(1.0, 1.0),
                new CustomPoint(2.0, 2.0),
                new CustomPoint(3.0, 3.0),
                new CustomPoint(4.0, 4.0),
                middle
        };
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        CustomPoint[] actualPoints = CoordinateSystem.arrayPoints(middle);
        assertEquals(expectedPoints.length, actualPoints.length);

    }
    @Test
    void testReadPointsFromFile() throws IOException {
        //dessa punkter måste matchas med de faktiska punkterna i points.txt för att testet ska funka
        List<CustomPoint> expectedPoints = new ArrayList<>();
        expectedPoints.add(new CustomPoint(0.0, 0.0));
        expectedPoints.add(new CustomPoint(2.0, 2.0));
        expectedPoints.add(new CustomPoint(3.0, 3.0));
        expectedPoints.add(new CustomPoint(4.0, 4.0));
        expectedPoints.add(new CustomPoint(0.0, 0.0));

        // Läs in punkterna från filen
        List<CustomPoint> actualPoints = CoordinateSystem.readPointsFromFile("points.txt");

        // Jämför de förväntade och faktiska punkterna
        assertEquals(expectedPoints.toString(), actualPoints.toString());
    }
    @Test
    void testGetDoubleInput() {
        // Set up the mock input
        String input = "abc\n--\n5,5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream); // Create a Scanner for the input

        // Execute the method and capture output
        double result = CoordinateSystem.getDoubleInput(scanner, "Enter a positive number: "); // Pass Scanner

        // Assert the result
        assertEquals(5.5, result, 0.0001);
    }
}