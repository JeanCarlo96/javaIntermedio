package com.jcma.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {

    public static void main(String[] args) {
        List<String> profesores = getList("Nicola", "Juan", "Zulema");

        System.out.println(longitudArreglo(profesores));

        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        profesores.forEach(System.out::println);
    }

    public static <T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }

    static <T> int longitudArreglo(List<T> arreglo){
        return arreglo.size();
    }

}
