package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Aria Hussein
 * Date: 2024-01-26
 * Time: 10:32
 * Project: GrupparbeteProg3
 * Copyright: MIT
 */

public class LengthTest {

    @Test
    public void testToMeter() {
        Length length = new Length(100, "centimeter");
        assertEquals(1.0, length.toMeter(), 0.001);
    }

    @Test
    public void testToCentimeter() {
        Length length = new Length(1, "meter");
        assertEquals(100.0, length.toCentimeter(), 0.001);
    }

    @Test
    public void testToKilometer() {
        Length length = new Length(1000, "meter");
        assertEquals(1.0, length.toKilometer(), 0.001);
    }

    @Test
    public void testToInches() {
        Length length = new Length(2.54, "centimeter");
        assertEquals(1.0, length.toInches(), 0.001);
    }

    @Test
    public void testToFeet() {
        Length length = new Length(304.8, "millimeter");
        assertEquals(1.0, length.toFeet(), 0.001);
    }

    @Test
    public void testToMillimeter() {
        Length length = new Length(1, "centimeter");
        assertEquals(10.0, length.toMillimeter(), 0.001);
    }
}
