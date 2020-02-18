package com.java8.features.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamReduceExample {

    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        int sum = integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Result of sum is " + sum);
        System.out.println("Amount of integers is " + integerList.stream().mapToInt(Integer::intValue).count());
        System.out.println("Result of multiplication every element is: " + integerList.stream().reduce(1, (a, b) -> a * b));;
        System.out.println("Result of add every element is: " + integerList.stream().reduce(0, (a, b) -> a + b));;
    }
}
