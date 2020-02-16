package com.java8.features.consumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BiConsumerExample {

    public static void main(String[] args) {
        BiConsumer<Integer, Integer> biConsumer1 = (a, b) -> System.out.println("Sum is: " + (a + b));
        biConsumer1.accept(10, 20);

        List<Integer> list1 = IntStream.rangeClosed(0, 3).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.rangeClosed(0, 2).boxed().collect(Collectors.toList());

        BiConsumer<List<Integer>, List<Integer>> biConsumer2 = (l1, l2) -> {
            if (l1.size() == l2.size()) {
                System.out.println("Same size");
            } else {
                System.out.println("Different size");
            }
        };
        biConsumer2.accept(list1, list2);

        BiConsumer<Integer, Integer> add = (a, b) -> System.out.println("Add: " + (a + b));
        BiConsumer<Integer, Integer> subtract = (a, b) -> System.out.println("Subtract: " + (a - b));
        BiConsumer<Integer, Integer> multiplication = (a, b) -> System.out.println("Multiplication: " + (a * b));

        System.out.println("Executing separately...");
        add.accept(10, 20);
        subtract.accept(10, 20);
        multiplication.accept(10, 20);

        System.out.println("Executing chained...");
        add.andThen(subtract).andThen(multiplication).accept(10, 20);
    }
}
