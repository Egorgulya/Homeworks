package org.example;

import java.util.*;

public class Company {
    static Integer income=0;
    public ArrayList<Employee> employees;


    public  Company(){
        employees = new ArrayList<>();
    }
    void hire(Employee employee){

        employees.add(employee);
        income =income+ employee.getProduction();
        Collections.sort(employees);
    }

    void fire(Employee employee){
        Collections.shuffle(employees);
        Iterator<Employee> iterator = employees.iterator();
        Employee employeeToFire = iterator.next();
        income = income - employee.getProduction();
        iterator.remove();
    }

    void hireAll(int operatorToHire,int managerToHire, int topManagerToHire){
        for ( int i =0; i < operatorToHire; i++){
            hire(new Operator());
        }
        for ( int i =0; i < managerToHire; i++){
            hire(new Manager());
        }
        for ( int i =0; i < topManagerToHire; i++){
            hire(new TopManager());
        }
    }

    public List<Employee> getLowestSalaryStaff(int count){
        Collections.sort(employees);
        ArrayList<Employee> lowestSalaries = new ArrayList<>();
        for (int i=0; i<=count; i++){
            System.out.println(employees.get(i).getMonthSalary()+" руб.");
            lowestSalaries.add(employees.get(i));
        }
        return lowestSalaries;
    }

    public List<Employee> getTopSalaryStaff(int count){
        Collections.sort(employees);
        Collections.reverse(employees);
        ArrayList<Employee> topSalaries = new ArrayList<>();
        for (int i=0; i<count; i++){
            System.out.println(employees.get(i).getMonthSalary()+" руб.");
            topSalaries.add(employees.get(i));
        }
        return topSalaries;
    }

    public static Integer getIncome(){
        return income;
    }
    public void employeesCount(){                                   // метод для проверки кол-ва сотрудников
        System.out.println(employees.size());
    }
    public void getAllSalarys() {                                  //метод для проверки зарплат
        Collections.sort(employees);
        for (Employee salary : employees){
            System.out.println(salary.getMonthSalary());
        }
    }
    public void getAllEmployees(){                                  //метод для вывода списка сотрудников по классам
        for (Employee employee : employees){

            System.out.println(employee.getClass().getName());
        }
    }
}
