package com.java8.features.methodref;

import java.util.Comparator;

public class MethodReferenceExample {

    public static void main(String[] args) {
        System.out.println("Compare values using static method: " + MethodReferenceExample.compareValues(10, 20));
        Comparator<Integer> comparator = MethodReferenceExample::compareValues;
        System.out.println("Compare values using static method reference: " + comparator.compare(10, 20));
    }

    public static int compareValues(Integer x, Integer y) {
        return Integer.compare(x, y);
    }
}
