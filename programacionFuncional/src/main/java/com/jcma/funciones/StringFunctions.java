package com.jcma.funciones;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {

    public static void main(String[] args) {

        UnaryOperator<String> quote = texto -> "'" + texto + "'";
        UnaryOperator<String> addMark = texto -> texto + "!!!";

        System.out.println(quote.apply("Jean Carlo Marchesini"));
        System.out.println(addMark.apply("Pamela Estefanía Carlosama"));

        BiFunction<Integer, Integer, Integer> multiplicación =
                (num1, num2) -> num1 * num2;

        System.out.println("Multiplicación: " + multiplicación.apply(3, 5));

        BiFunction<String, Integer, String> leftPad =
                (text, number) -> String.format("%" + number + "s", text);

        System.out.println(leftPad.apply("Java", 10));

    }

}
