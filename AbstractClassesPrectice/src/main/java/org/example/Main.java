package org.example;

public class Main {
    public static void main(String[] args) {
        String separator = "________________________________________________________"; //разделитель строк
        Company BigDickCompany = new Company();
        BigDickCompany.hireAll(180,80,10); //Нанимаем 180 операторов Operator, 80 менеджеров по продажам Manager, 10 топ-менеджеров TopManager.
        System.out.println("Прибыль компании : "+BigDickCompany.getIncome()+" руб.");

        BigDickCompany.getTopSalaryStaff(15); //Распечатайте список из 10–15 самых высоких зарплат в компании.

        System.out.println(separator); //разделитель строк

        BigDickCompany.getLowestSalaryStaff(30); // Распечатайте список из 30 самых низких зарплат в компании.

        System.out.println(separator); //разделитель строк

        for (int i = 0; i <BigDickCompany.employees.size(); i++ ) {                  //Увольте 50% сотрудников.
            BigDickCompany.fire(BigDickCompany.employees.get((int) Math.random()));
        }
        System.out.println("Прибыль компании : "+BigDickCompany.getIncome()+" руб.");

        BigDickCompany.getTopSalaryStaff(15); //Распечатайте список из 10–15 самых высоких зарплат в компании.
        System.out.println(separator); //разделитель строк

        BigDickCompany.getLowestSalaryStaff(30); // Распечатайте список из 30 самых низких зарплат в компании.

    }

}
h