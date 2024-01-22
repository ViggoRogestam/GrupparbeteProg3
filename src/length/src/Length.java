/**
 * Created by: Aria Hussein
 * Date: 2024-01-12
 * Time: 09:25
 * Project: GrupparbeteProg3
 * Copyright: MIT
 */
public class Length {
    private double value;
    private String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit.toLowerCase();
    }

    public double toMeter() {
        if (unit.equals("centimeter")) {
            return value / 100;
        } else if (unit.equals("millimeter")) {
            return value / 1000;
        } else if (unit.equals("inches")) {
            return value * 0.0254;
        } else if (unit.equals("feet")) {
            return value * 0.3048;
        } else if (unit.equals("kilometer")) {
            return value * 1000;
        } else if (unit.equals("meter")) {
            return value;
        }
        return 0;
    }

    public double toCentimeter() {
        if (unit.equals("meter")) {
            return value * 100;
        } else if (unit.equals("millimeter")) {
            return value * 0.1;
        } else if (unit.equals("inches")) {
            return value * 2.54;
        } else if (unit.equals("feet")) {
            return value * 30.48;
        } else if (unit.equals("kilometer")) {
            return value * 100000;
        } else if (unit.equals("centimeter")) {
            return value;
        }
        return 0;
    }

    public double toKilometer() {
        if (unit.equals("meter")) {
            return value * 0.001;
        } else if (unit.equals("millimeter")) {
            return value * 0.000001;
        } else if (unit.equals("inches")) {
            return value * 0.0000254;
        } else if (unit.equals("feet")) {
            return value * 0.0003048;
        } else if (unit.equals("centimeter")) {
            return value * 0.00001;
        } else if (unit.equals("kilometer")) {
            return value;
        }
        return 0;
    }

    public double toInches() {
        if (unit.equals("meter")) {
            return value * 39.3701;
        } else if (unit.equals("centimeter")) {
            return value * 0.393701;
        } else if (unit.equals("feet")) {
            return value * 12;
        } else if (unit.equals("millimeter")) {
            return value * 0.0393701;
        } else if (unit.equals("kilometer")) {
            return value * 39370.1;
        } else if (unit.equals("inches")) {
            return value;
        }
        return 0;
    }

    public double toFeet() {
        if (unit.equals("meter")) {
            return value * 3.28084;
        } else if (unit.equals("centimeter")) {
            return value * 0.0328084;
        } else if (unit.equals("millimeter")) {
            return value * 0.00328084;
        } else if (unit.equals("kilometer")) {
            return value * 3280.84;
        } else if (unit.equals("inches")) {
            return value * 0.0833333;
        } else if (unit.equals("feet")) {
            return value;
        }
        return 0;
    }

    public double toMillimeter() {
        if (unit.equals("meter")) {
            return value * 1000;
        } else if (unit.equals("centimeter")) {
            return value * 10;
        } else if (unit.equals("kilometer")) {
            return value * 1000000;
        } else if (unit.equals("inches")) {
            return value * 25.4;
        } else if (unit.equals("feet")) {
            return value * 304.8;
        } else if (unit.equals("millimeter")) {
            return value;
        }
        return 0;
    }
}
