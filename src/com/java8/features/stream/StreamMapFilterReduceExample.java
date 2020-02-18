package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.function.Predicate;

public class StreamMapFilterReduceExample {

    public static void main(String[] args) {
        Predicate<Person> personHeightPredicate = person -> person.getHeight() >= 140;
        Predicate<Person> personMalePredicate = person -> person.getGender().equals("Male");
        System.out.println("Total of kids is: " + PersonRepository.getAllPeople().stream()
                .filter(personHeightPredicate.and(personMalePredicate))
                .reduce(0, ((integer, person) -> integer + person.getKids()), Integer::sum));
    }
}
