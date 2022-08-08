<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
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