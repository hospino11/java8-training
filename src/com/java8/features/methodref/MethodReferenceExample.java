package com.java8.features.methodref;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class MethodReferenceExample {

    public static void main(String[] args) {
        System.out.println("Compare values using static method: " + MethodReferenceExample.compareValues(10, 20));
        Comparator<Integer> comparator = MethodReferenceExample::compareValues;
        System.out.println("Compare values using static method reference: " + comparator.compare(10, 20));

        UnaryOperator<String> upperCaseOperator = String::toUpperCase;
        System.out.println("Result upperCase class method reference is: " + upperCaseOperator.apply("java8"));

        Predicate<Person> personHeightLambdaPredicate = person -> person.getHeight() >= 140;
        Predicate<Person> personHeightMethodReferencePredicate = MethodReferenceExample::checkHeight;
        BiPredicate<Person, Integer> personIntegerBiPredicate = MethodReferenceExample::checkHeightWithParam;

        List<Person> people = PersonRepository.getAllPeople();
        System.out.println("Height Predicate with lambda expression result is: " + personHeightLambdaPredicate.test(people.get(0)));
        System.out.println("Height Predicate with method reference result is: " + personHeightMethodReferencePredicate.test(people.get(0)));
        System.out.println("Height BiPredicate with method reference result is: " + personIntegerBiPredicate.test(people.get(0), 160));
    }

    public static int compareValues(Integer x, Integer y) {
        return Integer.compare(x, y);
    }

    public static boolean checkHeight(Person person) {
        return person.getHeight() >= 140;
    }

    public static boolean checkHeightWithParam(Person person, Integer height) {
        return person.getHeight() >= height;
    }
}
