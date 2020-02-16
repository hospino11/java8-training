package com.java8.features.function;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<String, String> functionUpperCase = String::toUpperCase;
        Function<String, String> functionAddFeatures = (name) -> name.concat(" features");
        Function<Integer, String> functionAddNFeatures = (amount) -> "java has ".concat(amount.toString()).concat(" features");

        System.out.println("Result as uppercase: " + functionUpperCase.apply("java"));
        System.out.println("Result with features: " + functionAddFeatures.apply("java"));
        System.out.println("Result with then: " + functionUpperCase.andThen(functionAddFeatures).apply("java"));
        System.out.println("Result with compose: " + functionUpperCase.compose(functionAddFeatures).apply("java"));
        System.out.println("Result with compose different inputs: " + functionUpperCase.compose(functionAddNFeatures).apply(50));
    }
}
