package com.java8.features.supplier;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Person> personSupplier = () -> PersonRepository.getAllPeople().get(0);
        Supplier<List<Person>> peopleSupplier = () -> PersonRepository.getAllPeople();
        Supplier<Person> newPersonSupplier = () -> new Person("", 0, 0.0, "", 0, new ArrayList<>());

        System.out.println("Person supplier result: " + personSupplier.get());
        System.out.println("People supplier result: " + peopleSupplier.get());
        System.out.println("New Person supplier result: " + newPersonSupplier.get());
    }
}
