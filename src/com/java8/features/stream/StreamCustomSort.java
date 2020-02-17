package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Comparator;

public class StreamCustomSort {

    public static void main(String[] args) {
        System.out.println("People sorted by name");
        PersonRepository.getAllPeople().stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        System.out.println("People sorted by height");
        PersonRepository.getAllPeople().stream()
                .sorted(Comparator.comparingInt(Person::getHeight))
                .forEach(System.out::println);

        System.out.println("People sorted by name and reversed");
        PersonRepository.getAllPeople().stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(System.out::println);
    }
}
