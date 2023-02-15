package com.jcma.clases;

import com.jcma.utils.NombresUtils;

import java.util.List;
import java.util.function.Function;

public class Inferencia {

    public static void main(String[] args) {

        Function<Integer, String> funcionConvertidora =
                entero -> "Al doble: " + entero * 2;

        System.out.println(funcionConvertidora.apply(7));

        List<String> alumnos = NombresUtils.getList("Hugo", "Paco", "Luis");
        alumnos.forEach(System.out::println);

    }

}
