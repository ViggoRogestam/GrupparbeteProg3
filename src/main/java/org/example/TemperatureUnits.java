package org.example;

public class TemperatureUnits {

    public static double convTemp(double orgTemp, String fromUnit, String toUnit) {
        // Convert units to uppercase and get the first character
        char charToUnit = toUnit.toUpperCase().charAt(0);
        char charFromUnit = fromUnit.toUpperCase().charAt(0);

        // Convert original temperature to Celsius
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
                throw new IllegalArgumentException("Invalid original unit: " + fromUnit);
        }

        // Convert from Celsius to the target unit
        switch (charToUnit) {
            case 'C':
                return tempInCelsius;
            case 'F':
                return (tempInCelsius * 9.0 / 5.0) + 32;
            case 'K':
                return tempInCelsius + 273.15;
            default:
                throw new IllegalArgumentException("Invalid target unit: " + toUnit);
        }
    }

    public static void main(String[] args) {
        System.out.println(convTemp(32, "fare", "celsc"));
    }
}

