<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search User</title>
</head>
<body>
<div class="container">
	<div class="">
		<form action="${pageContext.request.contextPath}/search" method="post">
			<div class="form-group">
		<label for="name">Name:</label>
			 <input type="text"
				class="form-control" id="userName" name="userName" required/>
		</div>
		<button type="submit" class="btn btn-default">Search</button>
		</form>
	</div>
</div>
</body>
</html>