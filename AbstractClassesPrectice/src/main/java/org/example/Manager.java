package org.example;

public class Manager extends Company implements Employee{
    Integer salary = 100000;
    int production = (int)(115000+(Math.random()*25000));

    public Manager() {

    }

    public int getProduction(){
        return production;
    }

    @Override
    public Integer getMonthSalary() {
        return (Integer) (int) (salary+(production*0.05));
    }

}
