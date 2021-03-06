package com.java8.features.stream;

import com.java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Banana", "Pineapple");
        List<Integer> fruitNamesLength = fruits
                .stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Fruit names length is: " + fruitNamesLength);

        Set<String> peopleNamesUpperCase = PersonRepository.getAllPeople().stream()
                .map(person -> person.getName())
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println("People names in upper case: " + peopleNamesUpperCase);
    }
}
