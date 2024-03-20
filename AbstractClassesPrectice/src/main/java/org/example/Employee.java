package org.example;

public interface Employee extends Comparable <Employee> {
    Integer getMonthSalary();

    default int getProduction() {
        return 0;
    }
    default int compareTo(Employee employee){

        return this.getMonthSalary().compareTo(employee.getMonthSalary());
    }

}
