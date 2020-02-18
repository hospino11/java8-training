package com.java8.features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamLimitExample {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Grapes", "Banana", "Pineapple");
        fruits.stream().limit(2).forEach(System.out::println);

        List<Integer> numbers = IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
        Integer sumFirstNumbers = numbers.stream().limit(4).reduce(0, (a, b) -> a + b);
        System.out.println("Result of summing first numbers is: " + sumFirstNumbers);
        Integer sumLastNumbers = numbers.stream().skip(2).reduce(0, (a, b) -> a + b);
        System.out.println("Result of summing last numbers is: " + sumLastNumbers);
    }
}
