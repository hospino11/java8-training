package com.java8.features.methods;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultCustomSortExample {

    public static void main(String[] args) {
        Comparator<Person> personByNameComparator = (person1, person2) -> person1.getName().compareTo(person2.getName());
        Comparator<Person> personByHeightComparator = Comparator.comparingInt(Person::getHeight);

        List<Person> peopleList = PersonRepository.getAllPeople().stream().sorted(Comparator.comparing(Person::getName, Comparator.naturalOrder())).collect(Collectors.toList());
        System.out.println("People sorted by name is: ");
        peopleList.stream().forEach(System.out::println);
        peopleList = PersonRepository.getAllPeople().stream().sorted(Comparator.comparing(Person::getHeight, Comparator.naturalOrder())).collect(Collectors.toList());
        System.out.println("People sorted by height is: ");
        peopleList.stream().forEach(System.out::println);
        peopleList = PersonRepository.getAllPeople();
        peopleList.sort(personByNameComparator.thenComparing(Person::getHeight));
        System.out.println("People sorted by name and height is: ");
        peopleList.forEach(System.out::println);
        peopleList = PersonRepository.getAllPeople();
        peopleList.add(5, null);
        peopleList.sort(Comparator.nullsFirst(personByNameComparator.thenComparing(personByHeightComparator)));
        System.out.println("People sorted by name and height with nullFirst is: ");
        peopleList.forEach(System.out::println);
        peopleList.sort(Comparator.nullsLast(personByNameComparator.reversed().thenComparing(personByHeightComparator)));
        System.out.println("People sorted in reverse order by name and height with nullLast is: ");
        peopleList.forEach(System.out::println);
    }
}
