package com.java8.features.stream;

import java.util.Objects;
import java.util.Random;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFactoryMethodExample {

    public static void main(String[] args) {
        IntUnaryOperator oddGenerator = number -> number + 2;
        // iterate generates an infinite stream with the given function and ordered
        System.out.println("Odd numbers from 1 to 100 are: " + Stream.iterate(1, oddGenerator::applyAsInt).map(Object::toString).limit(50).collect(Collectors.joining(", ")));

        // generate creates an infinite stream with the given supplier and unordered
        System.out.println("Stream.generate() of 10 random double numbers is: " + Stream.generate(Math::random).map(Object::toString).limit(10).collect(Collectors.joining(", ")));;
        System.out.println("Stream.generate() of 10 random integer numbers is: " + Stream.generate(new Random()::nextInt).map(Objects::toString).limit(10).collect(Collectors.joining(", ")));

        // of creates an stream ordered with the given objects.
        System.out.println("Stream.of() example is: " + Stream.of("One", "Two", "Three", "Four").collect(Collectors.joining(", ")));;
    }
}
