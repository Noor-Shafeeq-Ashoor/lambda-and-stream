package com.ga.hw;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private List<Employee> employees = Arrays.asList(
            new Employee("Bezos, Jeff", LocalDate.of(2004, 4, 2), 68_109.00, "Male"),
            new Employee("Sheryl Sandberg", LocalDate.of(2014, 7, 1), 87_846.00, "Female"),
            new Employee("Buffet, Warren", LocalDate.of(2011, 7, 23), 95_035.00, "Male"),
            new Employee("Susan Wojcick", LocalDate.of(2015, 6, 1), 37_210.00, "Female"),
            new Employee("Zuckerberg, Mark", LocalDate.of(2016, 5, 12), 48_450.00, "Male"),
            new Employee("Brin, Sergey", LocalDate.of(2016, 8, 5), 74_416.00, "Male")
    );

    // TODO Print out all the elements in the supplied list:
    private <E> void printList(List<E> list) {
        list.forEach(System.out::println);
    }

    // TODO Print a list of all employees that earn $50,000 or more
    public void getEmployeesOver50k() {
        List<Employee> employees = this.employees.stream().filter(employee -> employee.getSalary() >= 50_000).toList();
         printList(employees);
    }

    // TODO Print a list of the names (not the Employee instances) of all employees who were hired on or after Jan. 1, 2012:
    // HINT: look it up for "LocalDate.of"
    public void getEmployeeNamesHiredAfter2012() {

        List<String> employees = this.employees.stream() .filter(employee -> !employee.getHireDate().isBefore(LocalDate.of(2012, 1, 1))).map(Employee::getName).toList();
        printList(employees);
    }

    // TODO Print the maximum salary of all employees.
    public void getMaxSalary() {
        double max = this.employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
        System.out.println("Max:" + max);
    }

    // TODO Print the minimum salary of all employees...
    public void getMinSalary() {

        double min = this.employees.stream().mapToDouble(Employee::getSalary).min().orElse(0);
        System.out.println("Min:" + min);
    }

    // TODO print the average salary of all Female and Male employees:
    public void getAverageSalaries() {
        double averageFemale = this.employees.stream().filter(employee -> employee.getGender().equals("Female")).mapToDouble(Employee::getSalary).average().orElse(0);
        double averageMale = this.employees.stream().filter(employee -> employee.getGender().equals("Male")).mapToDouble(Employee::getSalary).average().orElse(0);

        System.out.println("Averages: Female:" + averageFemale);
        System.out.println("Averages: Male:" + averageMale);
    }

    // TODO use the reduce() operation to find the Employee instance of the employees list with the highest salary:
    public void getMaximumPaidEmployee() {
        Employee highest = this.employees.stream().reduce((employee1, employee2) -> employee1.getSalary() > employee2.getSalary() ? employee1 : employee2).orElse(null);
        System.out.println(highest);
    }

    public static void main(String[] args) {

        Main Employee = new Main();

        System.out.println("earning 50K or more ");
        Employee.getEmployeesOver50k();

        System.out.println("hired on or after 2012 ");
        Employee.getEmployeeNamesHiredAfter2012();

        System.out.println(" Maximum Salary ");
        Employee.getMaxSalary();

        System.out.println("Minimum Salary");
        Employee.getMinSalary();

        System.out.println("Average Salaries ");
        Employee.getAverageSalaries();

        System.out.println(" Maximum Paid Employee ");
        Employee.getMaximumPaidEmployee();

    }
}
