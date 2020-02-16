package com.java8.features.function;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    public static void main(String[] args) {
        BiFunction<String, String, String> functionConcatStrings = (a, b) -> a + " " + b;
        Predicate<Person> personGender = person -> person.getGender().equals("Male");
        Predicate<Person> personHeight = person -> person.getHeight() >= 140;
        BiFunction<List<Person>, Predicate, Map<String, Double>> processPeople = (peopleList, predicate) -> {
            Map<String, Double> peopleSalaries = new HashMap<>();
            peopleList.forEach(person -> {
                if (predicate.test(person)) {
                    peopleSalaries.put(person.getName(), person.getSalary());
                }
            });
            return peopleSalaries;
        };

        System.out.println(functionConcatStrings.apply("java", "features"));
        System.out.println("People salaries are: " + processPeople.apply(PersonRepository.getAllPeople(), personHeight.and(personGender)));
    }
}
