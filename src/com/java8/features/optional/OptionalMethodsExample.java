package com.java8.features.optional;

import java.util.Optional;

public class OptionalMethodsExample {

    public static void main(String[] args) {
        Optional<String> ofNullable = Optional.ofNullable("java8");
        System.out.println(ofNullable.orElse("No data found"));
        /*
        Optional.of(null); throws NPE.
         */
        Optional<String> of = Optional.of("Java8 optional");
        System.out.println(of.orElse("No data found"));
        System.out.println(Optional.empty());
    }
}
