package employee.controller;

import employee.model.Employee;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee emp;
        emp = new Employee(123, "John", 10000,2.25, "male" );
        emp.display();
        System.out.println("Tax " + emp.calcTaxIsrael());
        System.out.println("Salary netto " + Employee.salaryNetto(emp.getSalary(),emp.calcTaxIsrael()));
        System.out.println(emp.getId());
        emp.setSalary(15000);
        System.out.println("New tax " + emp.calcTaxIsrael());

        var emp2 = new Employee(2000, "Mary", 12_000, 2.75, "female");

        double totalTax = emp.calcTaxIsrael() + emp2.calcTaxIsrael();
        System.out.println("Total tax = " + totalTax);

        System.out.println("Total salary = " + Employee.salaryNetto(
                emp.getSalary()+ emp2.getSalary(),totalTax));




    }
}