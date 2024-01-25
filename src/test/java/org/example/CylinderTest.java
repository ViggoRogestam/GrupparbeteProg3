package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderTest {

    @Test
    public void testCalculateCube() {
        // Sätter värden direkt istället för att hantera olika inmatningar
        double radius = 5.0;
        double height = 10.0;
        double expectedVolume = 785.3981633974483;

        // Hämtar beräkningen
        double actualVolume = Cylinder.calculateVolume(radius, height);

        // Kollar så resultatet matchar uträkningen
        assertEquals(expectedVolume, actualVolume, 0.001);
    }
}
