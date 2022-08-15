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
<title>Your Shelf</title>
</head>
<body>
	<div id="bigContainer">
		<div id="header">
			<div id="leftHead">
				<h1>Welcome, <c:out value="${user.firstName}"></c:out>!</h1>
				<h3>Books from everyone's shelves:</h3>
			</div>
			<div id="rightHead">
				<a href="/user/logout">Logout</a>
				<p><a href="/book/create">+ Add a book to your shelf</a></p>
			</div>
		</div>
	<!-- book table will go below -->
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th scope="col" class="text-center">ID</th>
				<th scope="col" class="text-center">Title</th>
				<th scope="col" class="text-center">Author</th>
				<th scope="col" class="text-center">Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${book}">
				<tr>
					<td class="text-center"><c:out value="${book.id}"/></td>
					<td class="text-center"><a href="/book/view/${book.id}"><c:out value="${book.title}"/></a></td>
					<td class="text-center"><c:out value="${book.author}"/></td>
					<td class="text-center"><c:out value="${book.getUser().firstName}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>