package com.java8.features.stream.parallel.dto;

public class Calculation {
    private int total;

    public int getTotal() {
        return total;
    }

    public void add(int input) {
        this.total += input;
    }
}
