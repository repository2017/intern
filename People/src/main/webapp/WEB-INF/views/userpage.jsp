<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Information 1.0.1</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	                rel="stylesheet">
</head>
	<body>
	<div class="container">
	<h3>User Info:</h3>
		<form:form method="post" commandName="userinfo">
			
			<fieldset class="form-group">
				<form:label class="form-check-label" path="name">Name</form:label>
				<form:input class="form-control" path="name" type="text" required="required"></form:input>
				<form:errors path="name" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label class="form-check-label" path="pin">PIN</form:label>
				<form:input class="form-control" path="pin" type="text" required="required"></form:input>
				<form:errors path="pin" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label class="form-check-label" path="email">Email</form:label>
				<form:input class="form-control" path="email" type="text" required="required"></form:input>
				<form:errors path="email" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label class="form-check-label" path="emailType">Email Type</form:label>
				<form:input class="form-control" path="emailType" type="text" required="required"></form:input>
				<form:errors path="emailType" cssClass="text-warning"></form:errors>
			</fieldset>
			
			
			<fieldset class="form-group">
				<form:label class="form-check-label" path="address">Address</form:label>
				<form:input class="form-control" path="address" type="text" required="required"></form:input>
				<form:errors path="address" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label class="form-check-label" path="addressType">Address Type</form:label>
				<form:input class="form-control" path="addressType" type="text" required="required"></form:input>
				<form:errors path="addressType" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<input class="btn btn-success" type="submit" value="Submit" ></input>
		</form:form>
	</div>
	<script src="webjars/jquery/2.2.4/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>