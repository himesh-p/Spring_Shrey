<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	  <title>Employee Form</title>
	  <style>
	      body {
	        font-family: Arial, sans-serif;
	        background-color: #f2f2f2;
	        padding: 20px;
	      }

	      h2 {
	        text-align: center;
	        color: #333;
	      }

	      form {
	        background-color: #fff;
	        max-width: 600px;
	        margin: auto;
	        padding: 30px;
	        border-radius: 10px;
	        box-shadow: 0 0 10px rgba(0,0,0,0.1);
	      }

	      label {
	        font-weight: bold;
	        display: block;
	        margin-top: 15px;
	        color: #444;
	      }

	      input[type="text"],
	      input[type="number"],
	      input[type="date"],
	      textarea {
	        width: 100%;
	        padding: 10px;
	        margin-top: 5px;
	        border: 1px solid #ccc;
	        border-radius: 5px;
	        box-sizing: border-box;
	      }

	      textarea {
	        resize: vertical;
	      }

	      input[type="submit"] {
	        margin-top: 20px;
	        background-color: #4CAF50;
	        color: white;
	        padding: 12px 20px;
	        border: none;
	        border-radius: 5px;
	        cursor: pointer;
	        width: 100%;
	        font-size: 16px;
	      }

	      input[type="submit"]:hover {
	        background-color: #45a049;
	      }
	    </style>
	</head>
	<body>
	  <h2>Employee Information Form</h2>
	  <form action="employees" method="post">
	    <label for="emp_id">Employee ID:</label><br>
	    <input type="text" id="emp_id" name="emp_id"><br><br>

	    <label for="name">Full Name:</label><br>
	    <input type="text" id="name" name="name"><br><br>

	    <label for="dept">Department:</label><br>
	    <input type="text" id="dept" name="dept"><br><br>

	    <label for="salary">Salary:</label><br>
	    <input type="number" id="salary" name="salary"><br><br>

	    <label for="exp">Experience (in years):</label><br>
	    <input type="number" id="exp" name="exp"><br><br>

	    <label for="join_date">Joining Date:</label><br>
	    <input type="date" id="join_date" name="join_date"><br><br>

	    <label for="dob">Date of Birth:</label><br>
	    <input type="date" id="dob" name="dob"><br><br>

	    <label for="address">Address:</label><br>
	    <textarea id="address" name="address" rows="3" cols="30"></textarea><br><br>

	    <label for="city">City:</label><br>
	    <input type="text" id="city" name="city"><br><br>

	    <label for="state">State:</label><br>
	    <input type="text" id="state" name="state"><br><br>

	    <label for="country">Country:</label><br>
	    <input type="text" id="country" name="country"><br><br>

	    <label for="zipcode">Zipcode:</label><br>
	    <input type="text" id="zipcode" name="zipcode"><br><br>

	    <input type="submit" value="Submit">
	  </form>
	</body>
	</html>
