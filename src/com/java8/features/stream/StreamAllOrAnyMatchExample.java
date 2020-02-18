package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamAllOrAnyMatchExample {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Grapes", "Banana", "Pineapple");
        System.out.println("Length check: " + fruits.stream().allMatch(fruit -> fruit.length() > 7));
        System.out.println("Length check: " + fruits.stream().anyMatch(fruit -> fruit.length() > 7));
        Predicate<Person> personTaller = person -> person.getHeight() >= 140;
        Predicate<Person> personMale = person -> person.getGender().equals("Male");
        System.out.println("Everyone is taller than 140? " + PersonRepository.getAllPeople().stream().allMatch(personTaller));
        System.out.println("Anyone is taller than 140 and male? " + PersonRepository.getAllPeople().stream().anyMatch(personTaller.and(personMale)));
    }
}
