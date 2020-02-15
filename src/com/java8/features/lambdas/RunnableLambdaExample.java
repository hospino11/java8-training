package com.java8.features.lambdas;

public class RunnableLambdaExample {

    public static void main(String[] args) {
        // Before
        Runnable runnableBefore = new Runnable() {

            @Override
            public void run() {
                System.out.println("Runnable before executed");
            }
        };
        new Thread(runnableBefore).start();

        // After
        Runnable runnableAfter = () -> System.out.println("Runnable after executed");
        new Thread(runnableAfter).start();

        Runnable runnableAfterCurlyBraces = () -> {
            System.out.println("Runnable after with curly braces executed in the first line");
            System.out.println("Runnable after with curly braces executed in the second line");
        };
        new Thread(runnableAfterCurlyBraces).start();

        new Thread(() -> {
            System.out.println("Runnable after inside the thread in the first line");
            System.out.println("Runnable after inside the thread in the second line");
        }).start();
    }
}
