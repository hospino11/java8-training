package com.java8.features.optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        System.out.println("Result of Optional.ofNullable is: " + Optional.ofNullable("Java"));
        Optional<String> name = Optional.ofNullable(null);
        /*
        Optional.ofNullable(null).get can throw java.util.NoSuchElementException if there is no element.
         */
        System.out.println("Name is: " + name.orElse("No Data Found"));
        name = Optional.ofNullable("Java test");
        System.out.println("Name is: " + name.orElse("No Data Found"));
    }
}
