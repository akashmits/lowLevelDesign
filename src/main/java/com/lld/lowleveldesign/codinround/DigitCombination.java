package com.lld.lowleveldesign.codinround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitCombination {
    /*
    Given a string containing digits from 2-9,
     return all possible letter combinations that the number could represent.
     The mapping of digits to letters is the same as on a telephone keypad:


2 -> "abc",  3 -> "def",
4 -> "ghi",  5 -> "jkl",  6 -> "mno",
7 -> "pqrs", 8 -> "tuv",  9 -> "wxyz"

example
1.
 digits = "23"

["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

2.
digits = ""

output : -
[]


3.
digits = "2"

output :-
["a", "b", "c"]

     */
    Map<Integer,String> mapping;
    public DigitCombination (){

       // 2 -> "abc",  3 -> "def",
         //       4 -> "ghi",  5 -> "jkl",  6 -> "mno",
           //     7 -> "pqrs", 8 -> "tuv",  9 -> "wxyz"
        mapping= new HashMap<>();
        mapping.put(2,"abc");
        mapping.put(3,"def");
        mapping.put(4,"ghi");
        mapping.put(5,"jkl");
        mapping.put(6,"mno");
        mapping.put(7,"pqrs");
        mapping.put(8,"tuv");
        mapping.put(9,"wxyz");

    }
    public static void main(String [] arg){
        DigitCombination digitCombination= new DigitCombination();
        List<String> test1=digitCombination.findAllLetter("23");
        System.out.println("Test 1:"+test1);

        List<String> test2=digitCombination.findAllLetter("");
        System.out.println("Test 2:"+test2);

        List<String> test3=digitCombination.findAllLetter("2");
        System.out.println("Test 3:"+test3);

    }
    public List<String> findAllLetter(String input){

        List<String> result = new ArrayList<>();

        for(int i=0;i<input.length();i++){
            if(result.size()==0){
                String s=mapping.get(input.charAt(i)-48);
                for(int j=0;j<s.length();j++){
                    result.add(s.charAt(j)+"");
                }
            }else{
                String s=mapping.get(input.charAt(i)-48);
                List<String> temp=new ArrayList<>();
                for(String prevWord: result){
                    for(int j=0;j<s.length();j++){
                        temp.add(prevWord+s.charAt(j));
                    }
                }
                result=temp;
            }
        }
        return result;
    }
}
