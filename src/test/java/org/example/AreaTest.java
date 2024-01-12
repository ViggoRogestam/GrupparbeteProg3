package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

        // Testa metoden med olika radii
        assertEquals(0.0, Area.circle(0), delta);  // Förväntat resultat: 0 för en cirkel med radie 0
        assertEquals(Math.PI, Area.circle(1), delta);  // Förväntat resultat: π för en cirkel med radie 1
        assertEquals(4 * Math.PI, Area.circle(2), delta);  // Förväntat resultat: 4π för en cirkel med radie 2
        assertEquals(25 * Math.PI, Area.circle(5), delta);  // Förväntat resultat: 25π för en cirkel med radie 5
    }

}
