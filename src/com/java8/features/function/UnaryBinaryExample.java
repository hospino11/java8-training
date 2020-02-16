package com.java8.features.function;

import com.java8.features.repo.Person;
import com.java8.features.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryExample {

    public static void main(String[] args) {
        UnaryOperator<String> unaryOperatorToUpperCase = name -> name.toUpperCase();
        UnaryOperator<Integer> unaryOperatorAddTen = a -> a + 10;

        BinaryOperator<String> binaryOperator = (a, b) -> a + " " + b;
        BinaryOperator<Integer> binaryComparator = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        Comparator<Person> heightComparator = (a, b) -> Comparator.comparingInt(Person::getHeight).compare(a, b);
        BinaryOperator<Person> tallerPersonBinary = BinaryOperator.maxBy(heightComparator);
        BinaryOperator<Person> smallerPersonBinary = BinaryOperator.minBy(heightComparator);

        System.out.println("Result unary to upper case is: " + unaryOperatorToUpperCase.apply("java8"));
        System.out.println("Result unary add ten to 20 is: " + unaryOperatorAddTen.apply(20));
        System.out.println("Result of binary operator to concatenate two strings: " + binaryOperator.apply("java", "features"));
        System.out.println("Result of max comparison between 10 and 20 is: " + binaryComparator.apply(10, 20));
        List<Person> people = PersonRepository.getAllPeople();
        System.out.println("Person taller between " + people.get(0).getName() + " and " + people.get(1).getName() + " is: " + tallerPersonBinary.apply(people.get(0), people.get(1)));
        System.out.println("Person smaller between " + people.get(0).getName() + " and " + people.get(1).getName() + " is: " + smallerPersonBinary.apply(people.get(0), people.get(1)));
    }
}
