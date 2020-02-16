package com.java8.features.predicate;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Predicate;

public class PredicatePersonExample {

    public static void main(String[] args) {
        List<Person> personList = PersonRepository.getAllPeople();

        Predicate<Person> personHeight = per -> per.getHeight() >= 140;
        Predicate<Person> personMale = per -> per.getGender().equals("Male");

        personList.stream().filter(personHeight.and(personMale)).forEach(System.out::println);
    }
}
