package com.java8.features.stream.terminal;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPartitioningExample {

    public static void main(String[] args) {
        Predicate<Person> personHeightPredicate = person -> person.getHeight() >= 140;
        Map<Boolean, List<Person>> personByHeight = PersonRepository.getAllPeople().stream().collect(Collectors.partitioningBy(personHeightPredicate));
        personByHeight.forEach((isTaller, people) -> System.out.println((isTaller ? "Taller" : "Smaller") + " people: " + people));
        PersonRepository.getAllPeople().stream()
                .collect(Collectors.partitioningBy(person -> person.getHeight() >= 140, Collectors.groupingBy(Person::getGender)))
                .forEach((isTaller, peopleByHeight) -> peopleByHeight.forEach((gender, people) -> System.out.println((isTaller ? "Taller" : "Smaller") + " " + gender + ": " + people)));
    }
}
