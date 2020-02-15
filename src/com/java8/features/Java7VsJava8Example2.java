package com.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Java7VsJava8Example2 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sam", "Peter", "Billings", "Sam", "Barbara", "Bob");

        // Before
        Set<String> uniqueSet = new HashSet<>();
        List<String> uniqueList = new ArrayList<>();
        for (String name: names) {
            if (!uniqueList.contains(name)) {
                uniqueList.add(name);
            }
            if (!uniqueSet.contains(name)) {
                uniqueSet.add(name);
            }
        }
        System.out.println("Unique list is " + uniqueList);
        System.out.println("Unique set is " + uniqueSet);

        // After
        Set<String> uniqueValuesAsSet = names.stream().collect(Collectors.toSet());
        List<String> uniqueValuesAsList = names.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique values as List: " + uniqueValuesAsList);
        System.out.println("Unique values as Set: " + uniqueValuesAsSet);
    }
}
