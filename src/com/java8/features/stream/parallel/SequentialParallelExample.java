package com.java8.features.stream.parallel;

import java.time.LocalTime;
import java.util.stream.Stream;

public class SequentialParallelExample {

    public static void main(String[] args) {
        String[] elements = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Stream<String> stream = Stream.of(elements);
        System.out.println("----------- SEQUENTIAL -----------");
        printStream(stream);
        stream = Stream.of(elements);
        System.out.println("----------- PARALLEL -----------");
        printStream(stream.parallel());
    }

    private static void printStream(Stream<String> stream) {
        stream.forEach(element -> {
            System.out.println(LocalTime.now() + " Value: " + element + " - Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
