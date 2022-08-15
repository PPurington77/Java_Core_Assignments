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
<title>Edit <c:out value="${book.title}"/></title>
</head>
<body>
	<div id="bigContainer">
		<div id="header">
			<h1>Change your entry</h1>
			<a href="/user/shelves">back to the shelves</a>
		</div>
		<div id="cBook">
			<form:form action="/book/edit/${book.id}" method="post" modelAttribute="book">
				<input type="hidden" name="_method" value="put"/>
				
				<form:label path="title">Title:</form:label>
				<form:errors path="title" class="alert-danger"/>
				<form:input type="text" path="title"/>
				
				<form:label path="author">Author:</form:label>
				<form:errors path="author" class="alert-danger"/>
				<form:input type="text" path="author"/>
				
				<form:label path="thoughts">My thoughts:</form:label>
				<form:errors path="thoughts" class="alert-danger"/>
				<form:textarea path="thoughts" name="thoughts" cols="100%" rows="20"></form:textarea>		
				
				<input type="submit" value="Submit"/>
			
			</form:form>
		</div>
	</div>
</body>
</html>