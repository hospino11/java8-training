package com.java8.features.consumer;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
        Consumer consumer2 = consumer1.andThen((y) -> System.out.println("And then I print " + y));
        consumer1.accept("Java8");
        consumer2.accept("Java9?");
    }
}
