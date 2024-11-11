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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Student Management System</title>
</head>
<body>
	<div class="container my-5">
		<h3 class="text-primary text-center text-uppercase">Register a New Student</h3>
		<div class="col-md-6 container my-5">
			<%
				String message =  (String)request.getAttribute("message");
				String status = (String)request.getAttribute("status");
			%>
			<%
				if (status != null && message != null){
			%>
				<div class="alert text-center alert-<%= status == "success" ? "success" : "danger" %>" role="alert">
					<%= message %>
				</div>
			<% } %>
			
			<form id="register-student-form" action="AddStudent" method="POST">
				<div class="mb-3">
					<label for="firstname">First Name</label>
					<input id="firstname" type="text" name="firstname" placeholder="Enter first name ..." class="form-control" value="Eswar Krishna"/>
					<div class="form-text text-danger"  id="firstname-error"></div>	
				</div>
				<div class="mb-3">
					<label for="firstname">Last Name</label>
					<input id="lastname" type="text" name="lastname" placeholder="Enter last name ..." class="form-control" value="Maganti"/>
					<div class="form-text text-danger"  id="lastname-error"></div>	
				</div>
				<div class="mb-3">
					<label for="firstname">Email Address</label>
					<input id="email" type="text" name="email" placeholder="Enter email address ..." class="form-control" value="maganti.ek@gmail.com"/>
					<div class="form-text text-danger"  id="email-error"></div>	
				</div>
				<div class="mb-3">
					<label for="bio">Student Bio</label>
					<textarea id="bio" name="bio" placeholder="Enter first name ..." class="form-control" >DevOps Engineer</textarea>
					<div class="form-text text-danger"  id="bio-error"></div>	
				</div>
				<div>
					<button type="submit" class="btn btn-primary">
						<i class="bi bi-person-fill-add"></i>
						<span>Register Student</span>
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	const registerForm = document.querySelector('#register-student-form');
	
	console.log(registerForm);
	
	
	registerForm.addEventListener('submit', (e)=>{
		e.preventDefault();
		
		// fetching the input fields
		const firstname = document.querySelector("#firstname").value;
		const lastname = document.querySelector("#lastname").value;
		const email = document.querySelector("#email").value;
		const bio = document.querySelector("#bio").value;
		
		console.log(firstname);
		
		
		// fetching form error fields
		const firstname_error = document.querySelector("#firstname-error");
		const lastname_error = document.querySelector("#lastname-error");
		const email_error = document.querySelector("#email-error");
		const bio_error = document.querySelector("#bio-error");
		
		if (firstname === null || firstname === ""){
			//alert("First Name is required");
			firstname_error.innerHTML = "First Name is requrired";
		} 
		if (lastname === null || lastname === ""){
			lastname_error.innerHTML = "Last Name is requrired";
		}
		if (email === null || email === ""){
			email_error.innerHTML = "Email Address is requrired";
		}
		if (bio === null || bio === ""){
			bio_error.innerHTML = "Bio is requrired";
		}
		
		if(firstname && lastname && email && bio){
			/* fetch('AddStudent',{
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: {"firstname":firstname, "lastname":lastname, "email":email, "bio":bio}
			}).then(res=>res).then(data => console.log(data)).catch(err => console.log(err)); */
			registerForm.submit();
		}
		  
	}) 
</script>