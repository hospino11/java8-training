package com.java8.features.stream;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactoryAggregationExample {

    public static void main(String[] args) {
        System.out.println("Sum of IntStream from 1 to 50 is: " + IntStream.rangeClosed(1, 50).sum());
        IntStream.rangeClosed(1, 50).max().ifPresent(max -> System.out.println("Max value of IntStream from 1 to 50 is: " + max));
        LongStream.rangeClosed(1, 50).min().ifPresent(max -> System.out.println("Min value of LongStream from 1 to 50 is: " + max));
        LongStream.rangeClosed(1, 50).average().ifPresent(average -> System.out.println("Average of LongStream from 1 to 50 is: " + average));
    }
}
