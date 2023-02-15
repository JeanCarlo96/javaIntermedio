package com.jcma.funciones;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {

    public static void main(String[] args) {

        // Creamos una función (Forma Antigua)
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        // Utilizamos la función
        System.out.println(square.apply(5));
        System.out.println(square.apply(25));

        // Creación de una función (Forma Actual)
        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        // Utilizamos la función
        System.out.println(isOdd.apply(1));
        System.out.println(isOdd.apply(2));
        System.out.println(isOdd.apply(3));
        System.out.println(isOdd.apply(4));


        // Interfaz Predicate
        Predicate<Integer> isEven = x -> x % 2 == 0;

        // Uso del predicate
        System.out.println(isEven.test(1));
        System.out.println(isEven.test(2));
        System.out.println(isEven.test(3));
        System.out.println(isEven.test(4));

        // Uso de Predicator con clases
        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6.0;

        // Probando predicado
        Student jeanCarlo = new Student(5.9);
        System.out.println("Student is: " + isApproved.test(jeanCarlo));


    }

    private static class Student {
        private double calificacion;

        public Student(double calificacion){
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }
    }

}
