package com.java8.features.stream.terminal;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.stream.Collectors;

public class StreamMappingCountingExample {

    public static void main(String[] args) {
        System.out.println("Names from repository are: " + PersonRepository.getAllPeople().stream()
                .collect(Collectors.mapping(Person::getName, Collectors.joining(", ", "[", "]"))));
        System.out.println("Total of persons taller than 140 are: " + PersonRepository.getAllPeople().stream()
                .filter(person -> person.getHeight() >= 140)
                .collect(Collectors.counting()));
    }
}
