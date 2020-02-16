package com.java8.features.lambdas;

import java.util.function.Consumer;

public class LambdaLocalVariableExample {

    static int k = 0;

    public static void main(String[] args) {
        int i = 10;

        Consumer<Integer> processOperation = (j) -> {
            //i can't be modified here. e.g i++
            System.out.println("The value of local variable (i) is: " + i);
            System.out.println("The lambda variable (j) value is: " + j);
            //k can be modified here 'cause is a class level variable. e.g k = k + 5
            System.out.println("The value of the class level variable (k) before updating it is: " + k);
            k = k + 5;
            System.out.println("The value of the class level variable (k) after updating is: " + k);
        };

        processOperation.accept(15);
    }
}
