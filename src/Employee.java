import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.function.Predicate;
import java.util.regex.*;
import java.util.stream.Collectors;



 public final class Employee {

        private final String name;
        private final Date dob;
        private final double salary;

        public Employee(String name, Date dob, Double salary) {
            this.name = name;
            this.dob = dob;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Date getDob() {
            return dob;
        }

        public double getSalary() {
            return salary;
        }

        public List<String> getEmployeeNames(List<Employee> employees){

            List<Employee> anotherList=employees;

            for(Employee e:employees){

            }

            Predicate<Employee> predicateEmployee=x-> x.getSalary()>10000;


             return  employees.stream()
                    .filter(predicateEmployee)
                    .map(Employee::getName)
                    .collect(Collectors.toList());




            //TODO: return the name of all the employees whose salary is more than 10000

        }




    }




