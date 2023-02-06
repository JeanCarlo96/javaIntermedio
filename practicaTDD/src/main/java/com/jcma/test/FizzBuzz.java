package com.jcma.test;

public class FizzBuzz {

    public static String fizzBuzz(int n){

        boolean fizz = false;
        boolean buzz = false;

        if(n % 3 == 0){
            fizz = true;
        }

        if(n % 5 == 0){
            buzz = true;
        }

        if(fizz && buzz){
            return "FizzBuzz";
        }

        if(fizz){
            return "Fizz";
        }

        if(buzz){
            return "Buzz";
        }

        return n + "";
    }

}
