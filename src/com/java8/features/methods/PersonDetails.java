package com.java8.features.methods;

import com.java8.features.repo.Person;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface PersonDetails {

    double calculateTotalSalary(List<Person> people);

    default int totalChildren(List<Person> people) {
        return people.stream().filter(Objects::nonNull).mapToInt(Person::getKids).sum();
    }

    static List<String> personNames(List<Person> people) {
        return people.stream().filter(Objects::nonNull).map(Person::getName).collect(Collectors.toList());
    }
}
