package com.java8.features.stream.terminal;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamSummingAveragingExample {

    public static void main(String[] args) {
        System.out.println("Total of kids in the people list are: " + PersonRepository.getAllPeople().stream()
                .collect(Collectors.summingInt(Person::getKids)));
        System.out.println("Average of heights is: " + PersonRepository.getAllPeople().stream()
                .collect(Collectors.averagingInt(Person::getHeight)));
        System.out.println("Total is: " + Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .collect(Collectors.summingInt(Integer::intValue)));
    }
}
