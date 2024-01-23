package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSizeConverterTest {

    @Test
    void convertBytesToKilobytes() {
        double result = DataSizeConverter.convert(1024, DataSizeConverter.DataUnit.BYTES, DataSizeConverter.DataUnit.KILOBYTES);
        assertEquals(1, result);
    }

    @Test
    void convertKilobytesToMegabytes() {
        double result = DataSizeConverter.convert(1024, DataSizeConverter.DataUnit.KILOBYTES, DataSizeConverter.DataUnit.MEGABYTES);
        assertEquals(1, result);
    }

    @Test
    void convertMegabytesToGigabytes() {
        double result = DataSizeConverter.convert(1024, DataSizeConverter.DataUnit.MEGABYTES, DataSizeConverter.DataUnit.GIGABYTES);
        assertEquals(1, result);
    }

    @Test
    void convertGigabytesToTerabytes() {
        double result = DataSizeConverter.convert(1024, DataSizeConverter.DataUnit.GIGABYTES, DataSizeConverter.DataUnit.TERABYTES);
        assertEquals(1, result);
    }

    @Test
    void convertTerabytesToBytes() {
        double result = DataSizeConverter.convert(1, DataSizeConverter.DataUnit.TERABYTES, DataSizeConverter.DataUnit.BYTES);
        assertEquals(Math.pow(1024, 4), result);
    }

    @Test
    void convertWithZeroValue() {
        double result = DataSizeConverter.convert(0, DataSizeConverter.DataUnit.BYTES, DataSizeConverter.DataUnit.TERABYTES);
        assertEquals(0, result);
    }
}
