package com.java8.features.predicate;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerPredicateExample {

    public static void main(String[] args) {
        Predicate<Person> personHeight = per -> per.getHeight() >= 140;
        Predicate<Person> personGender = per -> per.getGender().equals("Male");
        BiPredicate<Integer, String> personFilter = (height, gender) -> height >= 140 && gender.equals("Male");
        BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
        Consumer<Person> personConsumer = per -> {
            if (personHeight.and(personGender).test(per)) {
                hobbiesConsumer.accept(per.getName(), per.getHobbies());
            }
        };
        Consumer<Person> personConsumerBiPredicate = per -> {
            if (personFilter.test(per.getHeight(), per.getGender())) {
                hobbiesConsumer.accept(per.getName(), per.getHobbies());
            }
        };

        List<Person> peopleList = PersonRepository.getAllPeople();
        System.out.println("Printing results using Consumer and Predicate...");
        peopleList.forEach(personConsumer);
        System.out.println("Printing results using Consumer and BiPredicate...");
        peopleList.forEach(personConsumerBiPredicate);
    }
}
