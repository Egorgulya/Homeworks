package org.example;

public class TopManager extends Company implements Employee {
    Integer salary = 150000;
    public TopManager() {
    }


    @Override
    public Integer getMonthSalary() {

        int monthSalary;
        if (Company.getIncome() >= 10000000){

            monthSalary = (int) (salary + (salary * 1.5));
            return monthSalary;
        }
        return salary;
    }

}
