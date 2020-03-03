package com.java8.features.optional;

import java.util.Optional;

public class OptionalIfPresentExample {

    public static void main(String[] args) {
        Optional.ofNullable("Java 8").ifPresent(System.out::println);
    }
}
