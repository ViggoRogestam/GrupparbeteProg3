package org.example;

public class DataSizeConverter {

    private static final int BINARY_FACTOR = 1024;

    /**
     * Enum representing the various units of data size.
     */
    public enum DataUnit {
        BYTES, KILOBYTES, MEGABYTES, GIGABYTES, TERABYTES
    }

    /**
     * Converts a value from one data unit to another using the binary system.
     *
     * @param value       The value to be converted.
     * @param fromUnit    The unit of the value to be converted.
     * @param toUnit      The unit to convert the value to.
     * @return The converted value in the binary system.
     */
    public static double convert(double value, DataUnit fromUnit, DataUnit toUnit) {
        // Convert the value to bytes first
        double valueInBytes = switch (fromUnit) {
            case BYTES -> value;
            case KILOBYTES -> value * BINARY_FACTOR;
            case MEGABYTES -> value * Math.pow(BINARY_FACTOR, 2);
            case GIGABYTES -> value * Math.pow(BINARY_FACTOR, 3);
            case TERABYTES -> value * Math.pow(BINARY_FACTOR, 4);
        };

        // Then convert bytes to the target unit
        return switch (toUnit) {
            case BYTES -> valueInBytes;
            case KILOBYTES -> valueInBytes / BINARY_FACTOR;
            case MEGABYTES -> valueInBytes / Math.pow(BINARY_FACTOR, 2);
            case GIGABYTES -> valueInBytes / Math.pow(BINARY_FACTOR, 3);
            case TERABYTES -> valueInBytes / Math.pow(BINARY_FACTOR, 4);
        };
    }
}
