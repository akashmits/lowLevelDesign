package com.lld.lowleveldesign.java8Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

    public static void main(String [] arg){
        List<String> list = Arrays.asList("Melisandre", "Sansa","Jon", "Daenerys", null,"Joffery");

        List<String> lenghtLessThanSix = list.stream().filter(str -> str != null && str.length()<6).collect(Collectors.toList());

        System.out.println("Length Less Than size :"+ lenghtLessThanSix);
    }
}
