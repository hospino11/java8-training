package com.java8.features.methods;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultMethodExample {

    public static void main(String[] args) {
        List<String> peopleNameList = PersonRepository.getAllPeople().stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("Names before sorting");
        peopleNameList.stream().forEach(System.out::println);
        Collections.sort(peopleNameList);
        System.out.println("Names after sorting");
        peopleNameList.stream().forEach(System.out::println);

        peopleNameList = PersonRepository.getAllPeople().stream().map(Person::getName).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println("Names after sorting using stream.sort()");
        peopleNameList.stream().forEach(System.out::println);

        peopleNameList = PersonRepository.getAllPeople().stream().map(Person::getName).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Names after sorting in reverse order using stream.sort()");
        peopleNameList.stream().forEach(System.out::println);
    }
}
