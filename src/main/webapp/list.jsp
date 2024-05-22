<%@ page import="java.sql.Connection" %>
<%@ page import="com.company.company.util.DBUtil" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>
<h2>Employee List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Position</th>
        <th>Department</th>
    </tr>
    <%
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("ID") %></td>
        <td><%= rs.getString("Full_Name") %></td>
        <td><%= rs.getDate("Birthday") %></td>
        <td><%= rs.getString("Address") %></td>
        <td><%= rs.getString("Position") %></td>
        <td><%= rs.getString("Department") %></td>
    </tr>
    <%
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
</body>
</html>
