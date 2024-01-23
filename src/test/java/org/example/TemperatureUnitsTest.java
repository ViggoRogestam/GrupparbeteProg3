package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureUnitsTest {

    @Test
    void convertCelsiusToFahrenheit() throws Exception {
        double result = TemperatureUnits.convTemp(0, "celsius", "fahrenheit");
        assertEquals(32, result);
    }

    @Test
    void convertFahrenheitToCelsius() throws Exception {
        double result = TemperatureUnits.convTemp(32, "fahrenheit", "celsius");
        assertEquals(0, result);
    }

    @Test
    void convertCelsiusToKelvin() throws Exception {
        double result = TemperatureUnits.convTemp(0, "celsius", "kelvin");
        assertEquals(273.15, result);
    }

    @Test
    void convertKelvinToCelsius() throws Exception {
        double result = TemperatureUnits.convTemp(273.15, "kelvin", "celsius");
        assertEquals(0, result);
    }

    @Test
    void convertFahrenheitToKelvin() throws Exception {
        double result = TemperatureUnits.convTemp(32, "fahrenheit", "kelvin");
        assertEquals(273.15, result);
    }

    @Test
    void convertKelvinToFahrenheit() throws Exception {
        double result = TemperatureUnits.convTemp(273.15, "kelvin", "fahrenheit");
        assertEquals(32, result);
    }

    @Test
    void convertWithInvalidFromUnit() {
        assertThrows(Exception.class, () -> TemperatureUnits.convTemp(0, "invalid", "celsius"));
    }

    @Test
    void convertWithInvalidToUnit() {
        assertThrows(Exception.class, () -> TemperatureUnits.convTemp(0, "celsius", "invalid"));
    }
}