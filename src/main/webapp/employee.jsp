<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<form action="AddEmployeeServlet" method="post">
  ID: <input type="text" name="id"><br>
  Full Name: <input type="text" name="fullName"><br>
  Birthday: <input type="date" name="birthday"><br>
  Address: <input type="text" name="address"><br>
  Position: <input type="text" name="position"><br>
  Department: <input type="text" name="department"><br>
  <input type="submit" value="Submit">
  <input type="reset" value="Reset">
</form>
</body>
</html>
