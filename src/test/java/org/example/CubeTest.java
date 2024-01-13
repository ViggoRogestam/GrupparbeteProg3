package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeTest {

    @Test
    public void testCalculateCube() {
        // Skriv dina testfall här
        double sideLength = 3.0;
        double expectedVolume = 27.0;

        double actualVolume = Cube.calculateVolume(sideLength);

        assertEquals(expectedVolume, actualVolume, 0.001);
    }
}
