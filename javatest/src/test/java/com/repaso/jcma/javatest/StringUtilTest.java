package com.repaso.jcma.javatest;
class StringUtilTest {

    public static void main(String[] args) {

        String result = StringUtil.repeat("Hola", 3);
        System.out.println(result);

        if(result.equals("Hola Hola Hola ")){
            System.out.println("OK");
        }

    }

}