package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereTest {

    @Test
    public void testCalculateSphere() {
        // Sätter värden direkt istället för att hantera olika inmatningar
        double radius = 5.0;
        double expectedVolume = 523.5987755982989;

        // Hämtar beräkningen
        double actualVolume = Sphere.calculateVolume(radius);

        // Kollar så resultatet matchar uträkningen
        assertEquals(expectedVolume, actualVolume, 0.001);
    }
}
