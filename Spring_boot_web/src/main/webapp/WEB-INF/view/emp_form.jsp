<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Employee Form</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f7f8;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .form-container {
      background: #ffffff;
      padding: 30px 40px;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(0,0,0,0.1);
      width: 400px;
    }

    h2 {
      text-align: center;
      margin-bottom: 25px;
      color: #333;
    }

    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
      color: #555;
    }

    input, textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 14px;
    }

    textarea {
      resize: vertical;
    }

    button {
      width: 100%;
      background-color: #28a745;
      color: white;
      border: none;
      padding: 12px;
      border-radius: 5px;
      font-size: 16px;
      cursor: pointer;
      transition: background 0.3s ease;
    }

    button:hover {
      background-color: #218838;
    }
  </style>
</head>
<body>

  <div class="form-container">
    <h2>Employee Form</h2>
    <form action="/employees/save" method="post">
      <input type="hidden" name="id" value="${employee.id}" required />

      <label for="name">Name</label>
      <input type="text" id="name" name="name" value="${employee.name}" required />

      <label for="email">Email</label>
      <input type="email" id="email" name="email" value="${employee.email}" required />

      <label for="salary">Salary</label>
      <input type="number" id="salary" name="salary" value="${employee.salary}" required />

      <label for="address">Address</label>
      <textarea id="address" name="address" rows="3" value="${employee.address}" required></textarea>

      <button type="submit">Save</button> 
    </form>
  </div>

</body>
</html>
