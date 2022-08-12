<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure...this is for your style sheet -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
	<div id="ninjaContainer">
		<h1>New Ninja</h1>
		<form:form action="/create/ninja" method="post" modelAttribute="ninja">
		
			<form:label path="dojo">Choose a dojo:</form:label>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
				</c:forEach>
			</form:select>
			
			<form:label path="firstName">First Name: </form:label>
			<form:errors path="firstName" class="alert-danger"/>
			<form:input type="text" path="firstName" style="width:100%;"/>
			
			<form:label path="lastName">Last Name: </form:label>
			<form:errors path="lastName" class="alert-danger"/>
			<form:input type="text" path="lastName" style="width:100%;"/>
			
			<form:label path="age">Age: </form:label>
			<form:errors path="age" class="alert-danger"/>
			<form:input type="number" path="age" style="width:100%;"/>
			
			<input type="submit" value="create" class="btn btn-primary" />
		</form:form>
		<a href="/dojos">Back to Dojos</a>
	</div>
</body>
</html>