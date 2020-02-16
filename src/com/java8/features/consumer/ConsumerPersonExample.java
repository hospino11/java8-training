package com.java8.features.consumer;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPersonExample {

    public static void main(String[] args) {
        Consumer<Person> consumer1 = (p) -> System.out.println(p);
        Consumer<Person> consumer2 = (p) -> System.out.println(p.getName().toUpperCase());
        Consumer<Person> consumer3 = (p) -> System.out.println(p.getHobbies());

        List<Person> people = PersonRepository.getAllPeople();

        consumer1.andThen(consumer2.andThen(consumer3)).accept(people.get(0));
        consumer1.andThen(consumer2).andThen(consumer3).accept(people.get(0));

        System.out.println("Printing every people information...");
        people.forEach(consumer1);

        System.out.println("Printing just male and height >= 140 people");
        people.forEach(p -> {
            if (p.getGender().equals("Male") && p.getHeight() >= 140) {
                consumer2.andThen(consumer3).accept(p);
            }
        });
    }
}
