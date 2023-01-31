package com.jcma.test;

public class StringUtil {

    public static boolean isEmpty(String str){

        if(str == null){
            throw new IllegalArgumentException();
        }

        if("".equals(str) || "".equals(str.trim())){
            return true;
        }

        return false;

    }
}
