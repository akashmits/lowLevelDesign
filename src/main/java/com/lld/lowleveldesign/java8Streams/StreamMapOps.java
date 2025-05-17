package com.lld.lowleveldesign.java8Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapOps {

    public static void main(String [] arg){
        Employee.createEmployee();
        getEmployee();
    }
    public static void getEmployee(){
        Integer [] empIds = {1,2,3,4,9};
        Arrays.stream(empIds).mapToInt(Integer::intValue).sum();
        Arrays.stream(empIds).toList().stream().mapToInt(Integer::intValue).sum();

        List<Employee> employees = Stream.of(empIds).map(Employee :: getEmployee).collect(Collectors.toList());

        employees.stream().map(Employee::getEmpId).reduce(0,Integer::sum);
        System.out.println(employees);
        // only find name
        List<String> employeeName = employees.stream().filter(e -> e != null).map(Employee :: getEmpName).collect(Collectors.toList());

        System.out.println("Employee Name :|"+employeeName);


        String string = "Item1 10 Item2 25 Item3 30 Item4 45";

        Integer sum = Arrays.stream(string.split(" "))
                .filter((s) -> s.matches("\\d+"))
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.println(sum);
    }
}
