<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link href="css/customStyle.css" rel="stylesheet">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Register User</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
	$("#courseDiv").hide();
    $('#selectRole').on('change', function() {
      if ( this.value == 'student')
     
      {
        $("#courseDiv").show();
      }
      else
      {
        $("#courseDiv").hide();
      }
    });
});
</script>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div class="container">
	<form method="post" action="${pageContext.request.contextPath}/addUser">
		<div class="form-group">
		<label for="userName">User Name:</label>
			 <input type="text"
				class="form-control" id="userName" name="userName" />
			<%-- <p each="error" ${#fields.errors('userName')}>Validation Error</p> --%>
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="text"
				class="form-control" id="password" name="password"/>
		</div>
		<div class="form-group">
		<label for="selectRole">Select a role:</label>
			<select name="selectRole" id="selectRole">
				<option value="">Select one</option>
				<option value="student">Student</option>
				<option value="teacher">Teacher</option>
				<option value="visitor">Visitor</option>
			</select>
			<%-- <p each="error" ${#fields.errors('role')}>Select a role</p> --%>
		</div>
		<div class="form-group" id="courseDiv">
			<label for="course">Course:</label> 
			<select name="selectCourse" id="selectCourse">
				<option value="">Select one</option>
				<c:forEach items="${courseList}" var= "course">
				<option value="${course}">${course }</option>
				</c:forEach>
			</select>
			
			<br>
				<label for="address">Address:</label> <input type="text"
				class="form-control" id="address" name="address"/>
		</div>
		
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>
</body>
</html>