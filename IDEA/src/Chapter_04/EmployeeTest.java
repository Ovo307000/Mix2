package Chapter_04;

import java.time.LocalDate;
import java.util.Arrays;

public class EmployeeTest{
    public void run(){
        Employee[] employee = new Employee[5];

        employee[0] = new Employee("zhangSan", 7834, 2022, 12,2);
        employee[1] = new Employee("liSi",     4567, 2022, 12,2);
        employee[2] = new Employee("wangWU",   2478, 2022, 12,2);
        employee[3] = new Employee("zhaoLiu",  5347, 2022, 12,2);
        employee[4] = new Employee("liuQi",    6345, 2022, 12,2);

        Employee liErMaZi = new Employee();

        liErMaZi.setN("LiErMaZi");
        liErMaZi.setS(2000);
        liErMaZi.setHireDay(LocalDate.of(2000,2,3));
        liErMaZi.printInfo();
        Employee.id++;

        Employee gouDan = Employee.getFullExample("gouDan", 3000, 12, 8, 6);
        gouDan.printInfo();


        for (Employee e : employee){
            System.out.println("\u001b[38;2;255;255;0m");
            System.out.println();
            e.printInfo();

            System.out.println("\u001b[38;2;0;255;0m");
            e.raiseSalary(100);
            e.printInfo();
            System.out.println("\u001b[0m");
            Employee.id++;
        }

        System.out.println(Employee.id);
        System.out.println("Done");
    }

    public static void main(String[] args) {
        new EmployeeTest().run();
    }
}

class Employee {
    private String n;
    private int s;
    private LocalDate hireDay;
    static public int id = 0;

    public Employee() {
    }

    public Employee(String name, int salary, int year, int month, int day) {
        this.n = name;
        this.s = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public void printInfo() {
        System.out.println("Name : " + this.n + " ");
        System.out.println("Salary : " + this.s + " ");
        System.out.println("Hire day : " + this.hireDay + " ");
    }

    // Increase salary by percentage
    public void raiseSalary(int byPercent) {
        int raise = this.s * byPercent / 100;
        this.s += raise;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public static Employee getNullExample() {
        return new Employee();
    }

    public static Employee getFullExample(String name, int salary, int year, int month, int day) {
        return new Employee(name, salary, year, month, day);
    }
}