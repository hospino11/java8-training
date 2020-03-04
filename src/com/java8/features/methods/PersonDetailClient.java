package com.java8.features.methods;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.List;

public class PersonDetailClient {

    public static void main(String[] args) {
        PersonDetails personDetails = new PersonDetailsImpl();
        List<Person> personList = PersonRepository.getAllPeople();
        personList.add(5, null);
        double totalSalary = personDetails.calculateTotalSalary(personList);
        System.out.println("Total salary is: " + totalSalary);
        System.out.println("Total children is: " + personDetails.totalChildren(personList));
        System.out.println("Person names are: " + PersonDetails.personNames(personList));
        System.out.println("Person names from static method in subclass are: " + PersonDetailsImpl.personNames(personList));
    }
}
