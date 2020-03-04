package com.java8.features.optional;

import com.java8.features.repo.Address;
import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Optional;

public class OptionalMapExample {

    public static void main(String[] args) {
        Optional<Person> person = PersonRepository.getPersonOptional();
        if (person.isPresent()) {
            String name = person.map(Person::getName).orElse("Data not found");
            System.out.println("Name: " + name);

            Optional<Address> addressOptional = person.flatMap(person1 -> Optional.ofNullable(person1.getAddress()));
            System.out.println("Address is: " + addressOptional.orElse(new Address()));

            person.filter(person1 -> person1.getHeight() >= 140).ifPresent(person1 -> System.out.println("Address of filtered optional is: " + person1.getAddress()));
        }
    }
}
