package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereTest {

    @Test
    public void testCalculateSphere() {
        double radius = 5.0;
        double expectedVolume = 523.5987755982989;

        double actualVolume = Sphere.calculateVolume(radius);

        assertEquals(expectedVolume, actualVolume, 0.001);
    }
}
