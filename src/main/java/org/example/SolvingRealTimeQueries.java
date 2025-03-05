package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class SolvingRealTimeQueries {

    static List<Employee> employeeList = new ArrayList<Employee>();
    static {
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    }

    static void print(){

        //Query 3.1 : How many male and female employees are there in the organization?
        System.out.println("male and female employees " +
                employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));

        //Query 3.2 : Print the name of all departments in the organization?
        System.out.println("all departments in the organization "+ employeeList.stream().map(Employee::getDepartment).distinct().toList());

        //Query 3.3 : What is the average age of male and female employees?
        System.out.println("average age of male and female employees " + employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge))));

        //Query 3.4 : Get the details of highest paid employee in the organization?
        System.out.println("details of highest paid employee in the organization " + employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get());

        //Query 3.5 : Get the names of all employees who have joined after 2015?
        System.out.println("names of all employees who have joined after 2015 " + employeeList.stream().filter(emp -> emp.yearOfJoining>2015).map(Employee::getName).toList());

        //Query 3.6 : Count the number of employees in each department?
        Map<String,Long> emps = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        for(Map.Entry<String, Long> entry : emps.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        //Query 3.7 : What is the average salary of each department?
        Map<String,Double> emps1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        for(Map.Entry<String, Double> entry : emps1.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        //Query 3.8 : Get the details of youngest male employee in the product development department?
        System.out.println(employeeList.stream().filter(x -> x.getDepartment().equalsIgnoreCase("Product Development")).min(Comparator.comparing(Employee::getAge)).get());

        //Query 3.9 : Who has the most working experience in the organization?
        System.out.println(employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get());

        //Query 3.10 : How many male and female employees are there in the sales and marketing team?
        System.out.println(employeeList.stream().filter(x -> x.getDepartment().equalsIgnoreCase("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));

        //Query 3.11 : What is the average salary of male and female employees?
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary))));

        //Query 3.12 : List down the names of all employees in each department?
        Map<String, List<Employee>> employees = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        for(Map.Entry<String,List<Employee>> entry : employees.entrySet()){
            System.out.println("Department : " + entry.getKey());
            for (Employee emp : entry.getValue()){
                System.out.println("Employee Name " + emp.getName());
            }
        }

        //Query 3.13 : What is the average salary and total salary of the whole organization?
        System.out.println("Total Salary : " + employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Average Salary : " + employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary)));

        //Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream().collect(Collectors.partitioningBy(emp -> emp.getAge() <=25));
        Set<Map.Entry<Boolean, List<Employee>>> employeeSet =  partitionEmployeesByAge.entrySet();
        for (Map.Entry<Boolean, List<Employee>> entry : employeeSet)
        {
            System.out.println("----------------------------");

            if (entry.getKey())
            {
                System.out.println("Employees older than 25 years :");
            }
            else
            {
                System.out.println("Employees younger than or equal to 25 years :");
            }

            System.out.println("----------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list)
            {
                System.out.println(e.getName());
            }
        }
    }
}
