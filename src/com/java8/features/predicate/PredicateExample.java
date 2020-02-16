package com.java8.features.predicate;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> lessThan = a -> a < 50;
        Predicate<Integer> greaterThan = a -> a > 100;
        Predicate<Integer> equalsTo = a -> a.equals(0);

        System.out.println("Less than: " + lessThan.test(150));
        System.out.println("Greater than: " + greaterThan.test(150));
        System.out.println("Equals to: " + equalsTo.test(0));

        boolean result1 = lessThan.and(greaterThan).and(equalsTo).test(150);
        System.out.println("Testing all predicates with AND. The result is: " + result1);

        boolean result2 = lessThan.or(greaterThan).or(equalsTo).test(150);
        System.out.println("Testing all predicates with OR. The result is: " + result2);

        boolean result3 = lessThan.negate().and(greaterThan).test(150);
        System.out.println("Testing less than negated with greater than. The result is: " + result3);
    }
}
