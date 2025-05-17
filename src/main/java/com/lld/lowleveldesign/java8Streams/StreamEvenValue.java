package com.lld.lowleveldesign.java8Streams;

import org.apache.logging.log4j.util.PropertySource;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

A Stream in java - sequence of elements from a source.


Here are some common operations in Java streams.
You won't use all of these functions every time you encounter a stream,
but you have them available to use at will:

Filter: Returns a new stream that contains some of the elements of the original.
 It accepts the predicate to compute which elements should be returned in the new stream and removes the rest.
 In the imperative code we would employ the conditional logic to specify what should happen if an element satisfies the condition.
 In the functional style we don’t bother with ifs, we filter the stream and work only on the values we require.


Map: Transforms the stream elements into something else,
it accepts a function to apply to each and
every element of the stream and returns a stream of the values the parameter function produced.
This is the bread and butter of the Java streaming API. Map allows you to perform a computation on the data inside a stream.

Reduce: (also sometimes called a fold) Performs a reduction of the stream to a single element.
 If you want to sum all the integer values in the stream,
 you want to use the reduce function.
  If you want to find the maximum in the stream, reduce is your friend.

Collect: This is the way to get out of the streams world and obtain a concrete collection of values, like a list in the example above.
 */
public class StreamEvenValue {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> list = numbers.stream().filter(a -> a%2==0).collect(Collectors.toList());
        System.out.println("Orginal List :"+numbers+" | even number list |"+list);

        List<Integer> list1 = numbers.stream().filter(a -> a%2==0).map(a-> a*2).collect(Collectors.toList());

        System.out.println("Orginal List :"+numbers+" | double even number list |"+list1);


        // reduce function
        // sum all the numbers
        //Stream.reduce() is a terminal operation that performs a reduction on the elements of the stream.
        int x=numbers.stream().reduce(0,(a,b)->a+b);

        int sumVal=numbers.stream().mapToInt(Integer::intValue).sum();  //sum return

        System.out.println("Sum :"+x);

        int y= numbers.stream().reduce(0,Integer::sum);
        System.out.println("Sum :"+y);




        // find min number in the stream
        int maxNum= numbers.stream().reduce(Integer.MIN_VALUE,(a,b)->Math.max(a,b));
        System.out.println("Max Num:"+maxNum);
        // find max number in the stream

        OptionalInt maxValue= numbers.stream().mapToInt(Integer::intValue).max();

        if(maxValue.isPresent()){
            maxValue.getAsInt();
        }

        Optional<Integer> optional=numbers.stream().max(Comparator.naturalOrder());
        System.out.println("Optional Value max Value:"+optional.get());


        int min= numbers.stream().reduce(Integer.MAX_VALUE,(a,b)->Math.min(a,b));
        System.out.println("Max Num:"+min);


        System.out.println(numbers.stream().reduce(Integer.MAX_VALUE,Integer::min));

        System.out.println(numbers.stream().reduce(Integer.MIN_VALUE,Integer::max));

        // Given a list of strings, write a program to count the numbers of strings that start with specific character using streams
        List<String> stringList= List.of(new String[]{"Akash","Akashi", "Shayam", "Ravi", "Hari", "Puneet", "Monu", "Jeevansh"});

        long count=stringList.stream().filter( a-> a.startsWith("Ak")).count();
        System.out.println("Specific character :"+count);

        // convert a list of strings to uppercase using stream
        // stringList.stream().filter(s-> s.toUpperCase()).collect(Collectors.toList());
       List<String> upperCaseLetter= stringList.stream().map(String::toUpperCase).collect(Collectors.toList());




       System.out.println("UpperCase Letter :"+upperCaseLetter);

        System.out.println(stringList.stream().filter(s-> Boolean.parseBoolean(s.toUpperCase())).collect(Collectors.toList()));

        //to lower case list
        List<String> resultList= new ArrayList<>();
        stringList.stream().map(String::toLowerCase).forEach(s -> resultList.add(s));
        System.out.println(resultList);

        //given a list of integers, write a program to filter out the even numbers using streams
        //count the number elements in a list that satisfy a specific conditions using streams

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4);

        List<Integer> evenNumberList=numberList.stream().filter(a-> a%2==0).collect(Collectors.toList());

        long EventNumberCount=numberList.stream().filter(a-> a%2==0).count();

        System.out.println("Event Number Ele:"+evenNumberList+" | EventNumberCount|"+EventNumberCount);

        long evenNumSum=numberList.stream().filter(a-> a%2==0).mapToInt(Integer::intValue).sum();
        System.out.println("Event Number Sum:"+evenNumSum);


        // write a program to find the average of a list of floating point numbers using streams

        List<Float> floatNumbers = Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f);

        double avgFloat=floatNumbers.stream().mapToDouble(Float::floatValue).average().getAsDouble();

        System.out.println("Float Number :"+avgFloat);

        //given a list of strings, write a program to concatnate all the strings using streams

        List<String> stringList1= List.of(new String[]{"Akash","Akashi", "Shayam", "Ravi", "Hari", "Puneet", "Monu", "Jeevansh"});
        StringBuilder sb = new StringBuilder();
        stringList1.stream().forEach(a-> sb.append(a));


        System.out.println("Approach 1: "+sb.toString());

        String concateNateString=stringList1.stream().reduce(String::concat).get();


        System.out.println("Approach 2: "+concateNateString);

        String concatString=stringList.stream().reduce((a,b)-> (a+b)).get();
        System.out.println("Approach 3: "+concatString);
        //write a program to remove duplicates elements from a list using streams

       System.out.println("Approach four :Lower Case :"+ stringList.stream().collect(Collectors.joining("::")).toLowerCase());

        // reduce,
        // map, collect
        List<String> stringList2= List.of(new String[]{"Akash","Akash", "Shayam", "Ravi", "Hari", "Puneet", "Monu", "Jeevansh"});


        Set<String> removeDuplicate=stringList1.stream().collect(Collectors.toSet());

        System.out.println("Remove Duplicate :"+removeDuplicate);


        //given a list of objects, write a program to sort the objects based on a specific attribute using streams
        List<Person> personList= new ArrayList<>();

        personList.add(new Person(Gender.FEMALE,"rakhi"));
        personList.add(new Person(Gender.FEMALE,"varsha"));
        personList.add(new Person(Gender.FEMALE,"mona"));
        personList.add(new Person(Gender.FEMALE,"suvii"));
        Collections.sort(personList,Comparator.comparing(Person::getName));
        System.out.println("Approach 1:"+personList);

        List<Person> sortedList= personList.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        System.out.println("Approach 2:"+sortedList);

        //write a program ro check if all the elements in a list satisfy a given conditions using streams

        System.out.println(numberList.stream().allMatch(a-> a%2==0));


    }
}
