package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectionExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(new String[] {"John", "Adam", "Nancy"});
        for (String name: names) {
            System.out.println("Iteration #1 " + name);
        }
        for (String name: names) {
            System.out.println("Iteration #2 " + name);
        }
        Stream<String> streamNames = names.stream();
        streamNames.forEach(n -> System.out.println("Stream iteration #1 " + n));
        // Another execution of streamNames will
        // throw "java.lang.IllegalStateException: stream has already been operated upon or closed"
        // streamNames.forEach...

        List<String> peopleNames = PersonRepository.getAllPeople()
                .stream()
                .peek(System.out::println) // peek is for debugging purposes
                .map(Person::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
