 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department Details</title>
</head>
<body>
Counters = ${counters}
CurrentDept = ${current}
 
<form action = "depts" method = "post">
<table>
<tr>
	<td> Id </td>
	<td> ${dept.id}</td>
</tr>
<tr>
	<td> Name </td>
	<td> ${dept.name}</td>
</tr>
<tr>
	<td> Location</td>
	<td> ${dept.location}</td>
</tr>
	<td colspan = "2">
		<input type ="submit" name ="operation" value="First"/>
		<input type ="submit" name ="operation" value="Previous"/>
		<input type ="submit" name ="operation" value="Next"/>
		<input type ="submit" name ="operation" value="Last"/>
	</td>
</table>
 
 
<h2> Employees in the ${dept.name} Department</h2>
	<table>
		<tr>
		<th> Id </th>
		<th> Name </th>
		<th> Age </th>
		<th> Gender</th>
		<th> Salary</th>
		<th> Experience</th>
		<th> Level</th>
		<th> Dept_id</th>
		
		</tr>
	
		 <c:forEach items="${emps}" var="e">
		 <tr>
		<td> ${e.id} </td>
		<td> ${e.name}</td>
		<td> ${e.age}</td>
		<td> ${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		<td>${e.dept_id}</td>
		</tr>
		
		</c:forEach>
		<td> </td>
		</table>
 
</form>
</body>
</html>