<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	  <title>User Registration Form</title>
	  <style>
	    body {
	      font-family: Arial, sans-serif;
	      background-color: #eef2f3;
	      padding: 20px;
	    }

	    h2 {
	      text-align: center;
	      color: #333;
	    }

	    form {
	      background-color: #fff;
	      max-width: 500px;
	      margin: auto;
	      padding: 30px;
	      border-radius: 10px;
	      box-shadow: 0 0 15px rgba(0,0,0,0.1);
	    }

	    label {
	      display: block;
	      margin-top: 15px;
	      font-weight: bold;
	      color: #444;
	    }

	    input[type="text"],
	    input[type="email"],
	    input[type="password"] {
	      width: 100%;
	      padding: 10px;
	      margin-top: 5px;
	      border: 1px solid #ccc;
	      border-radius: 5px;
	      box-sizing: border-box;
	    }

	    input[type="submit"] {
	      margin-top: 25px;
	      background-color: #007bff;
	      color: white;
	      padding: 12px 20px;
	      border: none;
	      border-radius: 5px;
	      cursor: pointer;
	      width: 100%;
	      font-size: 16px;
	    }

	    input[type="submit"]:hover {
	      background-color: #0056b3;
	    }

	    .note {
	      font-size: 0.9em;
	      color: #666;
	      margin-top: 5px;
	    }
	  </style>
	</head>
	<body>

	  <h2>User Registration</h2>
	  <form action="users" method="post">
	    <label for="id">User ID:</label>
	    <input type="text" id="id" name="id" required>

	    <label for="name">Full Name:</label>
	    <input type="text" id="name" name="name" placeholder="e.g., John Doe" required>
	    <div class="note">* Enter both first and last name in one field.</div>

	    <label for="email">Email:</label>
	    <input type="email" id="email" name="email" required>

	    <label for="password">Password:</label>
	    <input type="password" id="password" name="password" required>

	    <input type="submit" value="Register">
	  </form>

	</body>
	</html>
