package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeTest {

    @Test
    public void testCalculateCube() {
        // Sätter värden direkt istället för att hantera olika inmatningar
        double sideLength = 3.0;
        double expectedVolume = 27.0;

        // Hämtar beräkningen
        double actualVolume = Cube.calculateVolume(sideLength);

        // Kollar så resultatet matchar uträkningen
        assertEquals(expectedVolume, actualVolume, 0.001);
    }
}
