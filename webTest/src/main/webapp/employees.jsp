<%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action= "employees" method="get">
<input type="hidden" name="operation" value="search">
		<select name="searchType">
			<option value="name">Search by Name</option>	
			<option value="ID">Search by ID</option>	
			<option value="age">Search by Age</option>	
			<option value="gender">Search by Gender</option>	
			<option value="salary">Search by Salary</option>	
			<option value="experience">Search by Experience</option>
			<option value="level">Search by Level</option>			
		</select>
		<input type="text" name="searchV"  placeholder="Enter Value.."/>
<!-- 		<input type="text" name="searchV" required="required" placeholder="Enter Value.."/>
-->		
		<select name="salarySort">
			<option value="<">LESS THAN</option>	
			<option value="=">EQUAL</option>	
			<option value=">">GREATER THAN</option>
		</select>
		<button type="submit">Search</button>
		<button type="submit" name="show" value="getAll">Show All</button>
<table>
<tr>
	<th><a href="employees?operation=sort&column=ID">ID</a></th>
	<th><a href="employees?operation=sort&column=NAME">Name</a></th>
	<th><a href="employees?operation=sort&column=AGE">Age</a></th>
	<th><a href="employees?operation=sort&column=GENDER">Gender</a></th>
	<th><a href="employees?operation=sort&column=SALARY">Salary</a></th>
	<th><a href="employees?operation=sort&column=EXPERIENCE">Experience</a></th>
	<th><a href="employees?operation=sort&column=LEVEL">Level</a></th>
	<th>Action</th>
	</tr>
 
<c:forEach items="${emps}" var="e">
	<tr>
		<td><c:out value="${e.id}"></c:out></td> 
		<%-- <td>${e.id}</td> --%>
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		<td>
			<a href="employees?operation=Update&id=${e.id}">Update</a>
			<a href="employees?operation=Delete&id=${e.id}">Delete</a>
		</td>
	</tr>
</c:forEach>
<tr>
	<td colspan ="7">
		<a  href="employees?operation=new">New Employee</a>    
	</td>
</tr>
</table>
<hr></hr>
<table>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Salary</th>
	<th>Experience</th>
	<th>Level</th>	
</tr>
<%	

	List<Employee> emps =(List<Employee>) request.getAttribute("emps");
	for(Employee e: emps){
%>		
	<tr>
		<td>
			<%= e.getId() %>
		</td>
		<td>
			<%= e.getName() %>
		</td>
		<td>
			<%= e.getAge() %>
		</td>
		<td>
			<%= e.getGender() %>
		</td>
		<td>
			<%= e.getSalary() %>
		</td>
		<td>
			<%= e.getExperience() %>
		</td>
		<td>
			<%= e.getLevel() %>
		</td>
	</tr>
<% } %>
</table>
</form>
</body>
</html>