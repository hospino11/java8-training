package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFindAnyFirstExample {

    public static void main(String[] args) {
        Predicate<Person> personHeightPredicate = person -> person.getHeight() >= 140;
        Predicate<Person> personMalePredicate = person -> person.getGender().equals("Male");

        PersonRepository.getAllPeople().parallelStream()
                .filter(personHeightPredicate)
                .findAny()
                .ifPresent(person -> System.out.println("Any person with height greater than 140 is: " + person));

        PersonRepository.getAllPeople().parallelStream()
                .filter(personMalePredicate)
                .findFirst()
                .ifPresent(person -> System.out.println("First male person is: " + person));
    }
}
