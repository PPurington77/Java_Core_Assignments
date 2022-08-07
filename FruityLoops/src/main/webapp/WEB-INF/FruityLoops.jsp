<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- for Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Fruity Loops</title>
</head>
<body>
	<div id="container">
	    <h1>Fruit Store</h1>
	    <table class="table table-danger">
	        <thead>
	            <tr class="table-light">
	                <th scope="col">Name</th>
	                <th scope="col">Price</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var ="fruit" items="${fruits}">
	        	<tr class="table-light">
	            	<td><c:out value="${fruit.name}"/></td>
	            	<td><c:out value="${fruit.price}"/></td>
	            </tr>
	            </c:forEach>
	        </tbody>
	    </table>
    </div>
</body>
</html>