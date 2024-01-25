package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuboidTest {

    @Test
    public void testCalculateCuboid() {
        // Sätter värden direkt istället för att hantera olika inmatningar
        double height = 10.0;
        double width = 3.0;
        double depth = 3.0;
        double expectedVolume = 90.0;

        // Hämtar beräkningen
        double actualVolume = Cuboid.calculateVolume(width, depth, height);

        // Kollar så resultatet matchar uträkningen
        assertEquals(expectedVolume, actualVolume, 0.001);
    }
}
