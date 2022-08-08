<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<div id="container">
		<form action="/submit" method="post">
			<div class="form-group">
				<label for="number">Pick any number from 5 to 25:</label>
				<select name="number">
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				</select>
				
				<label for="city">Enter the name of any city:</label>
				<input type="text" name="city" class="form-control"/>
				
				<label for="person">Enter the name of any real person:</label>
				<input type="text" name="person" class="form-control"/>
				
				<label for="hobby">Enter professional endeavor or hobby:</label>
				<input type="text" name="hobby" class="form-control"/>
				
				<label for="living">Enter any type of living thing:</label>
				<input type="text" name="living" class="form-control"/>
				
				<label for="message">Say something nice to someone:</label>
				<textarea name="message"cols="100%" rows="10%" class="form-control"></textarea>
			</div>
			<p><em>Send and Show a friend!</em></p>
			<input type="submit" value="Send" class="btn btn-primary"/>
		</form>
	</div>
</body>
</html>