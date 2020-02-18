package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMinMaxByExample {

    public static void main(String[] args) {
        PersonRepository.getAllPeople().stream()
                .collect(Collectors.maxBy((person1, person2) -> person1.getHeight() > person2.getHeight() ? 1 : person1.getHeight() < person2.getHeight() ? -1 : 0))
                .ifPresent(tallestPerson -> System.out.println("Tallest person is: " + tallestPerson));
        PersonRepository.getAllPeople().stream()
                .collect(Collectors.minBy(Comparator.comparingInt(Person::getHeight))).ifPresent(person -> System.out.println("Smallest person is: " + person));
        List<Person> tallestGroup = new ArrayList<>();
        PersonRepository.getAllPeople().stream()
                .max(Comparator.comparing(Person::getHeight))
                .ifPresent(tallestPerson -> tallestGroup.addAll(PersonRepository.getAllPeople().stream().filter(person -> person.getHeight() == tallestPerson.getHeight()).collect(Collectors.toList())));
        System.out.println("Tallest group is: " + tallestGroup);

    }
}
