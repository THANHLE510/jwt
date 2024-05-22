package com.company.company.controller;

import com.company.company.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    private Employee employeeDAO;

    public void init() {
        employeeDAO = new Employee("defaultFullName", "defaultBirthday", "defaultAddress", "defaultPosition", "defaultDepartment");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/newEmployee":
                    showNewEmployeeForm(request, response);
                    break;
                case "/insertEmployee":
                    insertEmployee(request, response);
                    break;
                case "/deleteEmployee":
                    deleteEmployee(request, response);
                    break;
                case "/editEmployee":
                    showEditEmployeeForm(request, response);
                    break;
                case "/updateEmployee":
                    updateEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        List<Employee> listEmployee = employeeDAO.selectAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("employee-list.jsp").forward(request, response);
    }

    private void showNewEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("employee-form.jsp").forward(request, response);
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeDAO.selectEmployee(id);
        request.setAttribute("employee", existingEmployee);
        request.getRequestDispatcher("edit-employee.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullName = request.getParameter("fullName");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String department = request.getParameter("department");

        Employee employee = new Employee(fullName, birthday, address, position, department);
        employeeDAO.updateEmployee(employee);
        response.sendRedirect("AddEmployeeServlet");
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        String fullName = request.getParameter("fullName");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String department = request.getParameter("department");

        Employee newEmployee = new Employee(fullName, birthday, address, position, department);
        employeeDAO.insertEmployee(newEmployee);
        response.sendRedirect("AddEmployeeServlet");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        response.sendRedirect("AddEmployeeServlet");
    }
}
