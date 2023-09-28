package Chapter_04;

import java.time.LocalDate;
public class EmployeeTest{
    public static Employee carftEmployee() {
        return new Employee();
    }
    public void setEmployee(){
        Employee[] employee = new Employee[5];

        employee[0] = new Employee("zhangSan", 7834, 2022, 12,2);
        employee[1] = new Employee("liSi",     4567, 2022, 12,2);
        employee[2] = new Employee("wangWU",   2478, 2022, 12,2);
        employee[3] = new Employee("zhaoLiu",  5347, 2022, 12,2);
        employee[4] = new Employee("liuQi",    6345, 2022, 12,2);

        for (Employee e : employee){
            System.out.println("\u001b[38;2;255;255;0m");
            System.out.println("Before: vvv");
            e.printInfo();

            System.out.println("\u001b[38;2;0;255;0m");
            e.raiseSalary(100);
            System.out.println("After: vvv");
            e.printInfo();
            System.out.println("\u001b[0m");
        }
    }
    public void staticMethodTest(){
        Employee gouDan = Employee.getFullExample("Goudan", 3000, 2012, 8, 6);
        gouDan.printInfo();

        Employee liErMaZi = new Employee();
        liErMaZi.setName("LiErMaZi");
        liErMaZi.setSalary(2000);
        liErMaZi.setHireDay(LocalDate.of(2000,2,3));
        liErMaZi.printInfo();
    }

    public void completionPrompt() {
        System.out.println("Done");
    }
    public void run(){
        staticMethodTest();
        setEmployee();

        printEmployeeIdCount();
        completionPrompt();
    }

    public void printEmployeeIdCount()
    {
        System.out.println("Total number of employees = " + new Employee().getId());
    }
    public static void main(String[] args) {
        new EmployeeTest().run();
    }
}

class Employee {
    private String name;
    private int salary;
    private LocalDate hireDay;
    private static int id = 0;
    public Employee() {
        Employee.id += 1;
    }
    public Employee(String n, int s, int year, int month, int day) {
        if (n == null) {
            throw new IllegalArgumentException("Name can't be null");
        }

        Employee.id += 1;

        this.name = n;
        this.salary = s;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public void printInfo() {
        System.out.println("Name : " + this.name + " ");
        System.out.println("Salary : " + this.salary + " ");
        System.out.println("Hire day : " + this.hireDay + " ");
    }

    // Increase salary by percentage
    public void raiseSalary(int byPercent) {
        int raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public int getId() {
        return Employee.id;
    }

    public static Employee getNullExample() {
        return new Employee();
    }

    public static Employee getFullExample(String name, int salary, int year, int month, int day) {
        return new Employee(name, salary, year, month, day);
    }
}