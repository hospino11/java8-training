package com.java8.features;

@FunctionalInterface
public interface TestFunctionalInterface {

    void add();

    default void sayHi() {
        System.out.println("Hi");
    }

    default void sayBye() {
        System.out.println("Bye!");
    }

    static boolean validateEmpty(String value) {
        return value.isEmpty();
    }
}
