package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreamExample {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.forEach(System.out::println);

        Stream<Integer> integerArrayStream = Stream.of(new Integer[] {1, 2, 3, 4, 5, 6});
        System.out.println("Printing stream of array of Integers");
        integerArrayStream.forEach(System.out::println);

        Map<String, List<String>> hobbiesByPerson = PersonRepository.getAllPeople().stream()
                .collect(Collectors.toMap(Person::getName, Person::getHobbies));
        System.out.println("People hobbies are: " + hobbiesByPerson);

        BinaryOperator<List<String>> mergeHobbiesOperation = (hobbiesList, newHobbiesList) ->
                Stream.concat(hobbiesList.stream(), newHobbiesList.stream()).collect(Collectors.toList());
        Predicate<Person> personHeightPredicate = per -> per.getHeight() >= 140;
        Map<String, List<String>> hobbiesByPeopleTaller = PersonRepository.getAllPeople()
                .stream()
                .filter(personHeightPredicate)
                .collect(Collectors.toMap(Person::getName, Person::getHobbies, mergeHobbiesOperation, LinkedHashMap::new));

        System.out.println("People hobbies of people taller than 140 are: " + hobbiesByPeopleTaller);

        List<String> personHobbies = PersonRepository.getAllPeople()
                .stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), ArrayList::new)); //alternative of distinct().

        System.out.println("List of all hobbies found is: " + personHobbies);
    }
}
