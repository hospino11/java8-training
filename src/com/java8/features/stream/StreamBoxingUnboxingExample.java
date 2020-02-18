package com.java8.features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBoxingUnboxingExample {

    public static void main(String[] args) {
        System.out.println("Boxing example of 1 to 20 is: " + IntStream.rangeClosed(1, 20).boxed().map(Object::toString).collect(Collectors.joining(", ")));
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Unboxing example of 1 to 5 integers: " + Arrays.toString(numberList.stream().mapToInt(Integer::intValue).toArray()));
    }
}
