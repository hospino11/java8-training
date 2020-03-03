package com.java8.features.optional;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Optional;

public class OptionalIfElseExample {

    public static void main(String[] args) {
        String name = Optional.of(new Person()).map(Person::getName).orElse("Data not found");
        System.out.println("Name from optional of new Person() is: " + name);
        Optional<Person> personOptional = Optional.ofNullable(null);
        name = personOptional.map(Person::getName).orElse("Data not found");
        System.out.println("Name from optional ofNullable(null) is: " + name);
        personOptional = Optional.empty();
        name = personOptional.map(Person::getName).orElse("Data not found");
        System.out.println("Name from optional empty() is: " + name);
        name = PersonRepository.getPersonOptional().map(Person::getName).orElse("Data not found");
        System.out.println("Name from optional person is: " + name);
        name = Optional.of(new Person()).map(Person::getName).orElseGet(() -> {
            System.out.println("Notifying the problem to IT");
            return "Data not found";
        });
        System.out.println("Name from optional new Person() using orElseGet() is: " + name);
        name = Optional.of(new Person()).map(Person::getName).orElseThrow(() -> {
            System.out.println("Printing error in log: Missing required parameter");
            return new IllegalArgumentException("Data not found");
        });
        // This line is never processed by the exception thrown from the line above
        System.out.println("Name from optional new Person() using orElseThrow() is: " + name);
    }
}
