package com.lld.lowleveldesign.java8Streams;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@ToString
public class Person {
Gender gender;
String name;
public Person(Gender gender,String name){
    this.gender=gender;
    this.name=name;
}
public Gender getGender() { return gender; }
public String getName() { return name; }



    public static void main(String[] args) {
        List<Person> personList= new ArrayList<>();

        personList.add(new Person(Gender.FEMALE,"rakhi"));
        personList.add(new Person(Gender.FEMALE,"varsha"));
        personList.add(new Person(Gender.FEMALE,"mona"));
        personList.add(new Person(Gender.FEMALE,"suvii"));

        personList.add(new Person(Gender.MALE,"akash"));
        List<String> personListNew = new ArrayList<>();
      personList.stream().filter((person -> person.getGender()==Gender.FEMALE))
                .map(Person::getName)
                .map(String::toUpperCase)
                .forEach(name->personListNew.add(name));

        System.out.println("Femail List :"+personListNew);

       List<String> names= personList.stream().filter((person -> person.getGender()==Gender.FEMALE)).map(person -> person.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println("Femail List :"+names);



        Stream.of("Cathy", "Alba", "Beth")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));


    }
}