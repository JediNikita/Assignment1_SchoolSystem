<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
	<h3> User Details</h3>
	
	<table>
		<tr>
			<th>User Name</th>
			<th>User Role</th>
			<th>User Permissions</th>
			
		</tr>
		
		<tr>
			<td>${user.getUserName() }</td>
			<td>${user.getRole().getRoleName() }</td>
			<td><forEach items="${user.getListOfPermissions()}" var= "permission">
				<li> ${permission.getPermission()} </li>
				</forEach>
			</td>
			
		</tr>
			
	</table>
</body>
</html>