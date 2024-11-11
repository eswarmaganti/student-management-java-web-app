<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Students</title>
</head>
<body>
	<div class="container py-5 ">
		<h3 class="text-primary font-montserrat text-uppercase text-center">Student Details</h1>
		<table class="table table-striped mt-5">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email Address</th>
					<th>Bio</th>
					<th>Created At</th>
				</tr>
			</thead>
			<%@ page import="DAO.StudentDAO" %>
			<%@ page import="Beans.Student" %>
			<%@ page import="java.util.List" %>
			<%
				
				StudentDAO dao = new StudentDAO("jdbc:postgresql://localhost:5433/student_management_system","postgres","postgres");
				List<Student> students = dao.getStudentsDetails();
				for(Student student : students){
			%>
				<tr>
					<td><%= student.getId() %></td>
					<td><%= student.getFirstName() %></td>
					<td><%= student.getLastName() %></td>
					<td><%= student.getEmail() %></td>
					<td><%= student.getBio() %></td>
					<td><%= student.getCreatedAt() %></td>
				</tr>
			<% } %>
		</table>
	</div>
</body>
</html>