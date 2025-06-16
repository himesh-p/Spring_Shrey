<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
	<h2>Employees</h2>
	<a href = "/employees/add">Add New Employee</a>
	<table border = "1">
		<tr><th>ID</th><th>Name</th><th>Email</th><th>salary</th><th>address</th></tr>
		<c:forEach var="e" items="${emp}">
		       <tr>
		           <td>${e.id}</td>
		           <td>${e.name}</td>
		           <td>${e.email}</td>
				   <td>${e.salary}</td>
				   <td>${e.address}</td>
		           <td>
		               <a href="/employees/edit/${e.id}">Edit</a> |
		               <a href="/employees/delete/${e.id}">Delete</a>
		           </td>
	           </tr>
		</c:forEach>
	</table>
</body>
</html>