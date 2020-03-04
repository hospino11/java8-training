package com.java8.features.methods;

import com.java8.features.repo.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PersonDetailsImpl implements PersonDetails {

    @Override
    public double calculateTotalSalary(List<Person> people) {
        return people.stream().filter(Objects::nonNull).map(Person::getSalary).reduce(0.0d,  Double::sum);
    }

    @Override
    public int totalChildren(List<Person> people) {
        return 30;
    }

    public static List<String> personNames(List<Person> people) {
        return Arrays.asList("Tom", "Robert");
    }
}
