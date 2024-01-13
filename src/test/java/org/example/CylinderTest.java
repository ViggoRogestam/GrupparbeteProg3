package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CylinderTest {

    @Test
    public void testCalculateCube() {
        double radius = 5.0;
        double height = 10.0;
        double expectedVolume = 785.3981633974483;

        double actualVolume = Cylinder.calculateVolume(radius, height);

        assertEquals(expectedVolume, actualVolume, 0.001);
    }
}
