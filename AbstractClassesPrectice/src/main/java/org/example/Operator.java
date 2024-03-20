package org.example;

public class Operator extends Company implements Employee {
    Integer salary = 80000;

    public Operator() {
    }

    @Override
    public Integer getMonthSalary() {
        return salary;
    }


}
