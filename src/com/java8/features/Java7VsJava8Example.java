package com.java8.features;

import java.util.stream.IntStream;

public class Java7VsJava8Example {

    public static void main(String[] args) {
        // Before
        int total = 0;
        for (int i = 0; i <= 50; i++) {
            total += i;
        }
        System.out.println("Total is: " + total);

        int totalAfter = IntStream.rangeClosed(0, 50).sum();
        System.out.println("Total in Java8: " + totalAfter);
    }
}
