package com.java8.features.stream.terminal;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingExample {

    public static void main(String[] args) {
        Map<String, List<Person>> peopleByGender = PersonRepository.getAllPeople().stream()
                .collect(Collectors.groupingBy(Person::getGender, LinkedHashMap::new, Collectors.toList()));
        peopleByGender.forEach((key, value) -> System.out.println("Gender: " + key + " - People >>> " + value));

        PersonRepository.getAllPeople().stream()
                .collect(Collectors.groupingBy(person -> {
                    String classification;
                    if (person.getHeight() >= 140) {
                        if (person.getGender().equals("Male")) {
                            classification = "Tallest Male";
                        } else {
                            classification = "Tallest Female";
                        }
                    } else {
                        if (person.getGender().equals("Male")) {
                            classification = "Smallest Male";
                        } else {
                            classification = "Smallest Female";
                        }
                    }
                    return classification;
                }))
                .forEach((key, value) -> System.out.println(key + " are: " + value));

        // Second level grouping
        PersonRepository.getAllPeople().stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.groupingBy(person -> person.getHeight() >= 140 ? "Tallest" : "Smaller")))
                .forEach((key, value) -> value.forEach((heightKey, people) -> System.out.println("Gender: " + key + " - " + heightKey + ": " + people)));
        PersonRepository.getAllPeople().stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.summingInt(Person::getKids)))
                .forEach((gender, kidsAmount) -> System.out.println("For " + gender + " there are " + kidsAmount + " kids."));
    }
}
