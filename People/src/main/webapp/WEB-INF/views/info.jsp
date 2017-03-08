<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Real time info</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	                rel="stylesheet">
</head>
	<body>
	<div class="container">
		<table class="table table-striped">
			<caption><h3>Result (People):</h3></caption>
			<thead>
				<tr class="tr tr-success">
					<td>Id</td>
					<td>Name</td>
					<td>PIN</td>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${inf}" var="temp">
					<tr>
						<td>${temp.id}</td>
						<td>${temp.name}</td>
						<td>${temp.pin}</td>
						<td>
							<a class="btn btn-info" href="/update-person?id=${temp.id}">Update</a>
							<a class="btn btn-danger" onclick="return confirm('Are you sure you want to delete?')" href="/delete-person?id=${temp.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>