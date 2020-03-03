package com.java8.features.stream.parallel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamWhenNotToUseCaseExample {

    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 10000).boxed().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Sequential sum of numbers from 1 to 10000 is: " + sequentialSum(list));
        System.out.println("Parallel sum of numbers from 1 to 10000 is: " + parallelSum(list));
    }

    static int sequentialSum(List<Integer> numberList) {
        LocalDateTime start = LocalDateTime.now();
        int total = numberList.stream().reduce(0, Integer::sum);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Performance of sequentialSum is: " + Duration.between(start, end).toMillis());
        return total;
    }

    static int parallelSum(List<Integer> numberList) {
        LocalDateTime start = LocalDateTime.now();
        int result = numberList.stream().parallel().reduce(0, Integer::sum);
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Performance of parallelSum is: " + Duration.between(start, end).toMillis());
        return result;
    }
}
