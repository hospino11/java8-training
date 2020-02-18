package com.java8.features.stream;

import java.util.stream.IntStream;

public class NumericStreamMapExample {

    public static void main(String[] args) {
        System.out.println("Sum of int values from 1 to 10 as double is: " + IntStream.rangeClosed(1, 10).mapToDouble(value -> value).sum());
        System.out.println("Sum of int values from 1 to 10 as long is: " + IntStream.rangeClosed(1, 10).mapToLong(value -> value).sum());
        System.out.println("Sum of int values from 1 to 10 as long is: " + IntStream.rangeClosed(1, 10).mapToObj(value -> value).reduce(0, Integer::sum));
    }
}
