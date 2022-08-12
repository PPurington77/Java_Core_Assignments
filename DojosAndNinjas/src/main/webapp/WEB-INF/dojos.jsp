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
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<div id="container" class="d-flex justify-content-around">
		<div id="createDojo">
		<h1>New Dojo</h1>
		<form:form action="/dojos" method="post" modelAttribute="dojo">
		
			<form:label path="name">Dojo Name:</form:label>
			<form:errors path="name" class="alert-danger"/>
			<form:input type="text" path="name" style="width:100%;"/>
			<input type="submit" value="Create" class="btn btn-primary" id="createButton"/>
			
		</form:form>
		</div>
		<div id="allDojo">
			<h1>All Dojos:</h1>
			<c:forEach var="dojo" items="${dojos}">
				<h3><a href="/view/dojo/${dojo.id}"><c:out value="${dojo.name}"/></a></h3>
			</c:forEach>
		</div>
	</div>
	<div id="buttonCon" class="text-center">
		<a href="/ninja/new"><button class="btn btn-primary">Create a Ninja</button></a>
	</div>
</body>
</html>