package com.java8.features.stream.terminal;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoinigExample {

    public static void main(String[] args) {
        System.out.println("Data joined is: " + Stream.of('a', 'b', 'c', 'd', 'e')
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println("All repository names are: " + PersonRepository.getAllPeople().stream().map(Person::getName).collect(Collectors.joining(", ", "[", "]")));
    }
}
