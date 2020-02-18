package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Comparator;

public class StreamPeopleReduceExample {

    public static void main(String[] args) {
        PersonRepository.getAllPeople().stream().map(Person::getName).reduce((a, b) -> a.concat(",").concat(b)).ifPresent(names -> System.out.println("Result of every names is: " + names));
        String namesVersion2 = PersonRepository.getAllPeople().stream()
                .reduce("", (a, b) -> a.concat(",").concat(b.getName()), (c, d) -> c.concat(",").concat(d)); // We had to use the combiner because the stream is of Person and the identity of reduce is String. They don't match
        System.out.println("Result of names as version 2 is: " + namesVersion2);
        PersonRepository.getAllPeople().stream().reduce(((person, person2) -> person.getHeight() > person2.getHeight() ? person : person2)).ifPresent(person -> System.out.println("Tallest person is: " + person));
    }
}
