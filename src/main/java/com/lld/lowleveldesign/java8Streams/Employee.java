package com.lld.lowleveldesign.java8Streams;

import lombok.ToString;

import java.util.HashMap;

@ToString
public class Employee {

    int empId;
    String empName;
    static HashMap<Integer,Employee>  employee = new HashMap<>();
    public Employee(int empId, String empName){
        this.empId= empId;
        this.empName= empName;

    }

    public String getEmpName() {
        System.out.println("Employee Name :|"+empName);
        return empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public static void createEmployee(){
        employee.put(1, new Employee(1,"Akash"));
        employee.put(2, new Employee(2,"Suvidha"));
        employee.put(3, new Employee(3,"Mohan"));
        employee.put(4, new Employee(4,"Ram"));
        employee.put(5, new Employee(5,"Shayam"));

    }

    public static Employee getEmployee(int empId){
        System.out.println("EmpId :"+ empId);

        return employee.get(empId);

    }


}
