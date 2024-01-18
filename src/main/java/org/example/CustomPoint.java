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


    // Getter (för att komma åt getters) och setter metoder för x och y
    /**
     * Getter-metod för att hämta x-koordinaten.
     *
     * @return x-koordinaten för punkten
     */
        public double getX() {
            return x;
        }

    /**
     * Setter-metod för att sätta x-koordinaten.
     *
     * @param x den nya x-koordinaten att sätta
     */
        public void setX(double x) {
            this.x = x;
        }
    /**
     * Getter-metod för att hämta y-koordinaten.
     *
     * @return y-koordinaten för punkten
     */
        public double getY() {
            return y;
        }
    /**
     * Setter-metod för att sätta y-koordinaten.
     *
     * @param y den nya y-koordinaten att sätta
     */
        public void setY(double y) {
            this.y = y;
        }



    /**
     * Överskriden toString-metod för att få en läsbar representation av punkten.
     *
     * @return en sträng som representerar punktens koordinater
     */
    @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
}
