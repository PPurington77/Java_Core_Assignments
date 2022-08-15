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
<title><c:out value="${book.title}"/></title>
</head>
<body>
	<div id="bigContainer">
		<div id="header">
			<h1><c:out value="${book.title}"/></h1>
			<a href="/user/shelves">back to the shelves</a>
		</div>
		<c:choose>
			<c:when test="${book.getUser().id == user.id}">
				You read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>
				<p>Here are your thoughts:</p>
				<p><c:out value="${book.thoughts}"/></p>
			</c:when>
			<c:otherwise>
				<c:out value="${book.getUser().firstName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>
				<p>Here are <c:out value="${book.getUser().firstName}"/>'s thoughts:</p>
				<p><c:out value="${book.thoughts}"/></p>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${book.getUser().id == user.id}">
				<p><a href="/book/edit/${book.id}"><button class="btn btn-primary">Edit</button></a></p>
				<form action="/book/delete/${book.id}" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="Delete" class="btn btn-danger"/>
				</form>		
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</div>
</body>
</html>