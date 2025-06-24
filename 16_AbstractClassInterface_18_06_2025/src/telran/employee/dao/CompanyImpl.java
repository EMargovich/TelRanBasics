package telran.employee.dao;

import telran.employee.model.Employee;
import telran.employee.model.SalesManager;

import java.sql.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CompanyImpl implements Company {
    Employee[] employees;

    int size;



    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    @Override
    public boolean addEmployee(Employee employee) {
        boolean[] check = new boolean[3];
        check[0] = size < employees.length;
        check[1] = findEmployee(employee.getId()) == null;
        check[2] = employee != null;
        if (check[0] && check[1] && check[2]) {
            employees[size] = employee;
            size ++;
            return true;
        }
        return false;
    }

    @Override
    public Employee removeEmployee(int id) {
        if(findEmployee(id) != null) {
            for (int i = 0; i < size; i++) {
                if(employees[i].getId() == id) {
                    Employee fired = employees[i];
                    employees[i] = employees[size-1];
                    employees[size-1] = null;
                    size--;
                    return fired;
                }
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if(employees[i] != null) {
                sum += employees[i].calcSalary();
            }
        }
        return sum;
    }

    @Override
    public double averageSalary() {
        return totalSalary()/size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            if(employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    @Override
    public double totalSales() {
        double totalSales = 0;
        for (int i = 0; i < size; i++) {
            if(employees[i] instanceof SalesManager) {
                totalSales += ((SalesManager) employees[i]).getSalesValue();
            }
        }
        return totalSales;
    }

    @Override
    public Employee[] findEmployeesGreaterThan(int hours) {
        Predicate<Employee> predicate = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getHours() > 100;
            }
        };
        return findEmployeesByPredicate(predicate);
    }

    @Override
    public Employee[] findEmployeesSalaryBetween(double min, double max) {
        Predicate<Employee> predicate = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.calcSalary() >= min && employee.calcSalary() < max;
            }
        };
        return findEmployeesByPredicate(predicate);
    }

    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(employees[i])) {
                count++;
            }
        }

        Employee[] res = new Employee[count];

        for (int i = 0, j = 0; i < size; i++) {
            if (predicate.test(employees[i])) {
                res[j++] = employees[i];
            }
        }
        return res;
    }
}
