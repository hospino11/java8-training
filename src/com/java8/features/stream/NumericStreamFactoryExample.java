package com.java8.features.stream;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactoryExample {

    public static void main(String[] args) {
        System.out.println("IntStream.rangeClosed() from 1 to 6 is: " + IntStream.rangeClosed(1, 6).mapToObj(number -> String.valueOf(number)).collect(Collectors.joining(", ")));
        System.out.println("IntStream.range() from 1 to 6 is: " + IntStream.range(1, 6).mapToObj(number -> String.valueOf(number)).collect(Collectors.joining(", ")));
        System.out.println("LongStream.rangeClose() from 1 to 20 is: " + LongStream.rangeClosed(1, 20).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("LongStream.rangeClose().asDoubleStream() from 1 to 20 is: " + LongStream.rangeClosed(1, 20).asDoubleStream().mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("DoubleStream.iterate() from 1 to 20 is: " + DoubleStream.iterate(1.0d, value -> ++value).limit(20).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }
}
