package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * This class provides a method to convert temperatures between Celsius, Fahrenheit, and Kelvin.
 */
public class TemperatureUnits {

    /**
     * Converts a temperature from one unit to another.
     *
     * @param orgTemp   The original temperature to be converted.
     * @param fromUnit  The original unit of the temperature. Accepts "C", "F", or "K" (case-insensitive).
     * @param toUnit    The unit to convert the temperature to. Accepts "C", "F", or "K" (case-insensitive).
     * @return          The converted temperature.
     * @throws Exception If either fromUnit or toUnit is not one of "C", "F", or "K".
     */
    public static double convTemp(double orgTemp, String fromUnit, String toUnit) throws Exception {
        List<Character> charList = Arrays.asList('C', 'K', 'F');
        char charToUnit = toUnit.toUpperCase().charAt(0);
        char charFromUnit = fromUnit.toUpperCase().charAt(0);

        if (charList.contains(charToUnit) && charList.contains(charFromUnit)) {
            double tempInCelsius;
            switch (charFromUnit) {
                case 'C':
                    tempInCelsius = orgTemp;
                    break;
                case 'F':
                    tempInCelsius = (orgTemp - 32) * 5.0 / 9.0;
                    break;
                case 'K':
                    tempInCelsius = orgTemp - 273.15;
                    break;
                default:
                    throw new Exception("Invalid fromUnit: " + fromUnit);
            }

            switch (charToUnit) {
                case 'C':
                    return tempInCelsius;
                case 'F':
                    return (tempInCelsius * 9.0 / 5.0) + 32;
                case 'K':
                    return tempInCelsius + 273.15;
                default:
                    throw new Exception("Invalid toUnit: " + toUnit);
            }
        } else {
            throw new Exception("Invalid temperature unit(s)");
        }
    }
}