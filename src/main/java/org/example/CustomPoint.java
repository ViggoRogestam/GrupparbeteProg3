package org.example;

/**
 * Created by Lina Romilson
 * Date: 2024-01-15
 * Time: 15:26
 * Project GrupparbeteProg3
 * Copyright: MIT
 */
public class CustomPoint {
        private double x;
        private double y;

        public CustomPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Getter och setter metoder för x och y

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
        // Metod för att skriva ut punkten
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
}
