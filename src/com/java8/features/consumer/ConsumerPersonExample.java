package com.java8.features.consumer;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.function.Consumer;

public class ConsumerPersonExample {

    public static void main(String[] args) {
        Consumer<Person> consumer1 = (p) -> System.out.println(p);
        Consumer<Person> consumer2 = (p) -> System.out.println(p.getName().toUpperCase());
        Consumer<Person> consumer3 = (p) -> System.out.println(p.getHobbies());

        consumer1.andThen(consumer2.andThen(consumer3)).accept(PersonRepository.getAllPeople().get(0));
        consumer1.andThen(consumer2).andThen(consumer3).accept(PersonRepository.getAllPeople().get(0));
    }
}
