package com.java8.features.predicate;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerPredicateExample {

    public static void main(String[] args) {
        Predicate<Person> personHeight = per -> per.getHeight() >= 140;
        Predicate<Person> personGender = per -> per.getGender().equals("Male");
        BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
        Consumer<Person> personConsumer = per -> {
            if (personHeight.and(personGender).test(per)) {
                hobbiesConsumer.accept(per.getName(), per.getHobbies());
            }
        };

        PersonRepository.getAllPeople().forEach(personConsumer);
    }
}
