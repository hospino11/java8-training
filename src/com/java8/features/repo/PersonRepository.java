package com.java8.features.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonRepository {

    public static List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", 165, 2000, "Male", 2, Arrays.asList("Cricket", "Swimming", "Tennis")));
        people.add(new Person("Angel", 158, 5000, "Female", 2, Arrays.asList("Driving", "Music", "Football")));
        people.add(new Person("Dean", 140, 5700, "Male", 2, Arrays.asList("Cricket", "Driving", "Tennis")));
        people.add(new Person("Nancy", 130, 4900, "Female", 2, Arrays.asList("Cricket", "Swimming", "Tennis")));
        people.add(new Person("Harper", 125, 9000, "Female", 2, Arrays.asList("Football", "Swimming", "Tennis")));
        people.add(new Person("Alan", 110, 9500, "Male", 2, Arrays.asList("Cricket", "Swimming", "Tennis")));
        people.add(new Person("Campbell", 165, 1548, "Male", 2, Arrays.asList("Swimming", "Tennis")));

        return people;
    }

    public static Optional<Person> getPersonOptional() {
        return Optional.of(getAllPeople().get(0));
    }
}
