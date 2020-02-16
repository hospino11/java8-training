package com.java8.features.consumer;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerPersonExample {

    public static void main(String[] args) {
        List<Person> people = PersonRepository.getAllPeople();

        BiConsumer<String, List<String>> personBiConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
        BiConsumer<String, Double> salaryBiConsumer = (name, salary) -> System.out.println(name + " " + salary);

        people.forEach(person -> {
            personBiConsumer.accept(person.getName(), person.getHobbies());
            salaryBiConsumer.accept(person.getName(), person.getSalary());
        });
    }
}
