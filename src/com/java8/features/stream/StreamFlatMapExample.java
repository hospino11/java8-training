package com.java8.features.stream;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {

    public static void main(String[] args) {
        List<Integer> oddNumbers = Arrays.asList(1, 3, 5, 7);
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfNumbersList = Arrays.asList(oddNumbers, evenNumbers);
        System.out.println("Before flatten: " + listOfNumbersList);

        List<Integer> numbersList = listOfNumbersList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("After flatten: " + numbersList);

        List<String> hobbies = PersonRepository.getAllPeople().stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List of uniques hobbies: " + hobbies);

        long amountOfHobbies = PersonRepository.getAllPeople().stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println("Total of hobbies are: " + amountOfHobbies);
    }
}
