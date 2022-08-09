<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<div id="container_oki">
		<p>
			In <c:out value="${number}" /> years, you will live in <c:out 			value="${city}" /> with <c:out value="${ person}" /> as your roommate 			selling <c:out value="${hobby}" /> for a living. The next time you see a
			<c:out value="${living}" />, you will have good luck. Also, <c:out 			value="${message}"/>.
		</p>
	</div>
	<div id="aTag">
		<a href="/">Go Back</a>
	</div>
</body>
</html>