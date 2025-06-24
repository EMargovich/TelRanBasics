package telran.employee.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.employee.dao.Company;
import telran.employee.dao.CompanyImpl;
import telran.employee.model.Employee;
import telran.employee.model.Manager;
import telran.employee.model.SalesManager;
import telran.employee.model.WageEmployee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company;
    Employee[] firm;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        firm = new Employee[4];
        firm[0] = new Manager(1000,"John", "Smith", 180, 20_000, 20);
        firm[1] = new WageEmployee(2000, "Mary", "Smith", 180, 50);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 180, 100_000, 0.05);
        firm[3] = new SalesManager(4000, "Tigran", "Petrosian", 80, 500_000, 0.1);
        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);
        }
    }

    @Test
    void addEmployee() {
        //проверить, что есть куда добавлять, что такого сотрудника еще нет (по ID), что передан не null, увеличивать размер на 1
        assertFalse(company.addEmployee(firm[3]));
        Employee employee = new SalesManager(5000, "Jons", "Petrosian", 80, 500_000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.size());
        employee = new SalesManager(6000, "Jons", "Petrosian", 80, 500_000, 0.1);
        assertFalse(company.addEmployee(employee));
        assertEquals(5, company.size());
    }

    @Test
    void removeEmployee() {
        assertNull(company.removeEmployee(6000));
        assertEquals(firm[1], company.findEmployee(2000));
        assertEquals(firm[1], company.removeEmployee(2000));
        assertNull(company.findEmployee(2000));
        assertEquals(3, company.size());
    }

    @Test
    void findEmployee() {
        assertEquals(company.findEmployee(1000), firm[0]);
        assertEquals(company.findEmployee(4000), firm[3]);
        assertNull(company.findEmployee(8000));
    }

    @Test
    void totalSalary() {
        assertEquals(89080.0, company.totalSalary());
        company.removeEmployee(2000);
        assertEquals(80080.0, company.totalSalary());
        Employee employee = new SalesManager(6000, "Jons", "Petrosian", 80, 200_000, 0.1);
        company.addEmployee(employee);
        assertEquals(100080.0, company.totalSalary());
    }

    @Test
    void averageSalary() {
        assertEquals((89080.0008/4), company.averageSalary(),0.01);
        company.removeEmployee(2000);
        assertEquals(80080.0/3, company.averageSalary());
        Employee employee = new SalesManager(6000, "Jons", "Petrosian", 80, 200_000, 0.1);
        company.addEmployee(employee);
        assertEquals(100080.0/4, company.averageSalary());
    }

    @Test
    void size() {
        assertEquals(4, company.size());
    }

    @Test
    void printEmployees() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        PrintStream ps = new PrintStream(outContent);
        System.setOut(ps);

        company.printEmployees();

        assertEquals(    "Employee{id=1000, firstName='John', lastName='Smith', hours=180.0}" + System.lineSeparator()
                                + "Employee{id=2000, firstName='Mary', lastName='Smith', hours=180.0}" + System.lineSeparator()
                                + "Employee{id=3000, firstName='Peter', lastName='Jackson', hours=180.0}" + System.lineSeparator()
                                + "Employee{id=4000, firstName='Tigran', lastName='Petrosian', hours=80.0}" + System.lineSeparator()
                        , outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void printEmployees2 () {
        company.printEmployees();
    }

    @Test
    void totalSales() {
        assertEquals(600_000.0, company.totalSales());
        company.removeEmployee(3000);
        assertEquals(500_000.0, company.totalSales());
        Employee employee = new SalesManager(6000, "Jons", "Petrosian", 80, 200_000, 0.1);
        company.addEmployee(employee);
        assertEquals(700_000, company.totalSales());
    }

    @Test
    void findEmployeesGreaterThan() {
        Employee[] actual = company.findEmployeesGreaterThan(100);
        Employee[] expected = {firm[0], firm[1], firm[2]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findEmployeesSalaryBetween() {
        Employee[] actual = company.findEmployeesSalaryBetween(5000,10_000);
        Employee[] expected = {firm[1], firm[2]};
        assertArrayEquals(expected, actual);
    }
}