package com.example.demo.msisdn.domain;

public class MobileNumber {

    private String numbers[];

    public MobileNumber() {}

    public MobileNumber(String values[]) {
        this.numbers = values;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public void setNumbers(String[] numbers) {
        this.numbers = numbers;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "MobileNumber{" +
                "numbers=" + java.util.Arrays.toString(numbers) +
                '}';
    }
}
