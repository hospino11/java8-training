package com.java8.features.stream.parallel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SequentialParallelExample2 {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("Sum of all numbers from 0 to 10000 using sequential is: " + sumMethod(10000));
        System.out.println("Sum of all numbers from 0 to 10000 using parallel is: " + sumMethodParallel(10000));

        System.out.println("Performance in milliseconds of sum of all numbers from 0 to 1000000 using sequential is: " + checkPerformance(() -> sumMethod(1000000), 25));
        System.out.println("Performance in milliseconds of sum of all numbers from 0 to 1000000 using parallel is: " + checkPerformance(() -> sumMethodParallel(1000000), 25));
    }

    static long checkPerformance(Supplier<Integer> result, int numOfTimes) {
        LocalDateTime start = LocalDateTime.now();
        IntStream.range(0, numOfTimes).forEach(i -> result.get());
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        return duration.toMillis();
    }

    static int sumMethod(int endNumber) {
        return IntStream.rangeClosed(0, endNumber).sum();
    }

    static int sumMethodParallel(int endNumber) {
        return IntStream.rangeClosed(0, endNumber).parallel().sum();
    }
}
