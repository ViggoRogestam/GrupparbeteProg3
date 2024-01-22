package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Lina Romilson
 * Date: 2024-01-12
 * Time: 18:06
 * Project GrupparbeteProg3
 * Copyright: MIT
 */



    public class TestUtils {

        public static String captureSystemOut(Runnable runnable) {
            // Fånga upp System.out
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            PrintStream originalOut = System.out;
            System.setOut(printStream);

            // Kör koden som ska testas
            runnable.run();

            // Återställ System.out
            System.out.flush();
            System.setOut(originalOut);

            // Returnera den fångade utmatningen
            return outputStream.toString();
        }
    }