package com.java8.features.function;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionPersonExample {

    public static void main(String[] args) {
        Function<String, Integer> stringLength = String::length;
        Predicate<Person> personHeight = person -> person.getHeight() >= 140;
        Predicate<Person> personGender = person -> person.getGender().equals("Male");
        Predicate<Person> personValidation = person -> personHeight.and(personGender).test(person);
        Function<List<Person>, Map<String, Double>> personFunction = personList -> {
            Map<String, Double> personSalaries = new HashMap<>();
            personList.forEach(person -> {
                if (personValidation.test(person)) {
                    personSalaries.put(person.getName(), person.getSalary());
                }
            });
            return personSalaries;
        };

        System.out.println("Length of 'java features' is: " + stringLength.apply("java features"));
        List<Person> personList = PersonRepository.getAllPeople();
        Map<String, Double> personSalaries = personFunction.apply(personList);
        System.out.println("Person Salaries: " + personSalaries);
    }
}
