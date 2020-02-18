package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamFilterExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sam", "Anderson", "Peter", "Nancy");
        names.stream().filter(name -> name.length() > 3)
                .forEach(System.out::println);
        Predicate<Person> predicateMale = person -> person.getGender().equals("Male");
        PersonRepository.getAllPeople().stream()
                .filter(predicateMale)
                .filter(person -> person.getHeight() >= 140)
                .forEach(System.out::println);
    }
}
