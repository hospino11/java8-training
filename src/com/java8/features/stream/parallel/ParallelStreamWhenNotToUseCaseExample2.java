package com.java8.features.stream.parallel;

import com.java8.features.stream.parallel.dto.Calculation;

import java.util.stream.IntStream;

public class ParallelStreamWhenNotToUseCaseExample2 {

    public static void main(String[] args) {
        Calculation calculation = new Calculation();

        IntStream.rangeClosed(0, 2000).forEach(calculation::add);
        System.out.println("Result using sequential stream is: " + calculation.getTotal());

        calculation = new Calculation();
        IntStream.rangeClosed(0, 2000).parallel().forEach(calculation::add);
        System.out.println("Result using parallel stream is: " + calculation.getTotal());
    }
}
