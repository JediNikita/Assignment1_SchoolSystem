<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User Details</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$('#passwordDiv, #nameDiv, #addressDiv, #courseDiv').hide();
$('#whatUpdate').on("change", function() {
	$('#passwordDiv, #nameDiv, #addressDiv, #courseDiv').hide();
	  switch ($(this).val()) {
	    case 'name':
	      $('#nameDiv').show();
	      break;
	    case 'password':
	      $('#passwordDiv').show();
	      break;
	    case 'address':
	      $('#addressDiv').show();
	      break;
	    case 'course':
	      $('#courseDiv').show();
	      break;
	  }
	});
});
	
	
</script>
</head>
<body>
	<div class="container">
		<form method="post" action="${pageContext.request.contextPath}/update">
			<div class="form-group">
				<label for="what">What do you want to update?</label> <select
					name="what" id="whatUpdate">
					<option value="">Select one</option>
					<option value="name">Name</option>
					<option value="password">Password</option>
					<option value="course">Course</option>
					<option value="address">Address</option>
				</select>
			</div>
		
			<div class="form-group" id= passwordDiv>
				<label for="password">Password:</label> <input type="text"
					class="form-control" id="password"  name="password"/>
			</div>
			<div class="form-group" id= nameDiv>
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name"/>
			</div>
			<div class="form-group" id= courseDiv>
				<label for="course">Course:</label> <input type="text"
					class="form-control" id="course" name="course"/>
			</div>
			<div class="form-group" id= addressDiv>
				<label for="password">Address:</label> <input type="text"
					class="form-control" id="address"  name="address" />
			</div>
			
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>