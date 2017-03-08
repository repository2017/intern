<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SEARCH ENGINE 1.0.1</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	                rel="stylesheet">
</head>
	<body>
		<div class="container">
			<form action="search" method="post">
				<p><font color="red">${errorMessage}</font></p>
				 <input type="text" required="required" class="form-control" name="search"/><br>
				 <input type="submit" class="btn" value="Search"></input>
			</form>
			<a class="btn btn-warning"  href="/add-person">Add Data</a>
		</div>
		<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>