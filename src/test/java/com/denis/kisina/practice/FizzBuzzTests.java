package com.denis.kisina.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FizzBuzzTests {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void test1() {
        int n = 15;

        List<String > expected = Arrays.asList(new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"});

        Assert.assertEquals(expected, fizzBuzz.fizzBuzz(n));
    }
}