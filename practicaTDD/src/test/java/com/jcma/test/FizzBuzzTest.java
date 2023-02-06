package com.jcma.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void number_is_divisible_by_three() {
        assertThat(FizzBuzz.fizzBuzz(6), is("Fizz"));
    }

    @Test
    public void number_is_divisible_by_five() {
        assertThat(FizzBuzz.fizzBuzz(10), is("Buzz"));
    }

    @Test
    public void number_is_divisible_by_three_and_five() {
        assertThat(FizzBuzz.fizzBuzz(30), is("FizzBuzz"));
    }

    @Test
    public void number_is_not_divisible_by_three_and_five() {
        assertThat(FizzBuzz.fizzBuzz(16), is("16"));
    }

}