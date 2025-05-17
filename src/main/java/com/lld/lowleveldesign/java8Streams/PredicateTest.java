package com.lld.lowleveldesign.java8Streams;

import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String [] arg){
        var values = List.of(1,2,3,4,5,6,7,8);

        //predicate use strategy design pattern
        System.out.println("Total Sum:"+operation(values, number -> true));
        System.out.println("Even Sum :"+operation(values, number -> number%2 == 0));
        System.out.println(operation(values, number -> number %2 != 0));

    }

    public static int operation(List<Integer> list, Predicate<Integer> selector){
        int result =0;
        for(var num : list){
            if(selector.test(num)){
                result = result+ num;
            }
        }
        return result;
    }


}
