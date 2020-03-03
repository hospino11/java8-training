package com.java8.features.optional;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Optional;

public class OptionalExample1 {

    private static final String NO_DATA_FOUND = "No data found";

    public static void main(String[] args) {
        System.out.println("Person name of new person object is: " + personName(new Person()));
        Optional<String> personName = personNameWithOptional(PersonRepository.getPersonOptional());
        System.out.println("Person name is: " + personName.orElse(NO_DATA_FOUND));
        personName = personNameWithOptional(Optional.of(new Person()));
        System.out.println("Person name of new Person() is: " + personName.orElse(NO_DATA_FOUND));
        personName = personNameWithOptional(Optional.ofNullable(null));
        System.out.println("Person name of null is: " + personName.orElse(NO_DATA_FOUND));
    }

    static String personName(Person person) {
        if (null != person) {
            return person.getName();
        }
        return "No Data Found";
    }

    static Optional<String> personNameWithOptional(Optional<Person> personOptional) {
        if (personOptional.isPresent()) {
            return personOptional.map(Person::getName);
        }
        return Optional.empty();
    }
}
