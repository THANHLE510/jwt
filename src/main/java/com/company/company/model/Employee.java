package com.company.company.model;

import java.sql.SQLException;
import java.util.List;

public class Employee {
    private int id;
    private String fullName;
    private String birthday;
    private String address;
    private String position;
    private String department;

    public Employee(String fullName, String birthday, String address, String position, String department) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public static List<Employee> selectAllEmployees() throws SQLException, ClassNotFoundException {
        // Code to select all employees from the database and return them as a list
        // Implement your database access logic here
        return null; // Placeholder, replace with actual implementation
    }

    public static Employee selectEmployee(int id) throws SQLException, ClassNotFoundException {
        // Code to select an employee by id from the database and return it
        // Implement your database access logic here
        return null; // Placeholder, replace with actual implementation
    }

    public static void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        // Code to update an employee in the database
        // Implement your database access logic here
    }

    public static void insertEmployee(Employee newEmployee) throws SQLException, ClassNotFoundException {
        // Code to insert a new employee into the database
        // Implement your database access logic here
    }

    public static void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        // Code to delete an employee from the database by id
        // Implement your database access logic here
    }
}
