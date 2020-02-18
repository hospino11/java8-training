package com.java8.features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamExample {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(4, 5, 6, 7);
        System.out.println("Total is: " + numberList.stream().reduce(0, Integer::sum));
        System.out.println("Total using IntStream is: " + IntStream.rangeClosed(4, 7).sum());
    }
}
