package com.java8.features.stream.parallel;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamUseCaseExample {

    public static void main(String[] args) {
        List<String> hobbies;
        System.out.println("------------- SEQUENTIAL -------------");
        LocalDateTime start = LocalDateTime.now();
        hobbies = getHobbiesAsSequential();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Duration for sequential hobbies retrieval in milliseconds is: " + duration.toMillis() + ". Hobbies found were: " + hobbies);

        System.out.println("------------- PARALLEL -------------");
        start = LocalDateTime.now();
        hobbies = getHobbiesAsParallel();
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("Duration for parallel hobbies retrieval in milliseconds is: " + duration.toMillis() + ". Hobbies found were: " + hobbies);
    }

    static List<String> getHobbiesAsSequential() {
        return PersonRepository.getAllPeople().stream().map(Person::getHobbies).flatMap(List::stream).collect(Collectors.toList());
    }

    static List<String> getHobbiesAsParallel() {
        return PersonRepository.getAllPeople().parallelStream().map(Person::getHobbies).flatMap(List::stream).collect(Collectors.toList());
    }
}
