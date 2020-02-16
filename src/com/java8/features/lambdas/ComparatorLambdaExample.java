package com.java8.features.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {

    public static void main(String[] args) {
        // Before
        Comparator comparatorBefore = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x.compareTo(y);
            }
        };

        System.out.println("Comparing 15 and 20 with before comparator: " + comparatorBefore.compare(15, 20));

        // After
        Comparator<Integer> comparatorAfter = (Integer x, Integer y) -> x.compareTo(y);
        System.out.println("Comparing 15 and 20 with after comparator: " + comparatorAfter.compare(15, 20));

        Comparator<Integer> comparatorAfterWithInference = (x, y) -> x.compareTo(y);
        System.out.println("Comparing 15 and 20 with after comparator and inference: " + comparatorAfterWithInference.compare(15, 20));
    }
}
