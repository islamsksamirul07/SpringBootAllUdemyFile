<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!-- eti ke bole jsp fragments . er dara amra nav er code tike Header.jspf theke an6i-->
<%@ include file="common/header.jspf" %>
	
<!-- eti ke amra header.jspf theke nich6i -->
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todos List</title> -->

<!-- er dara amra bootstrap er css add kor6i -->
<link href="webjars/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- eti ke bole jsp fragments . er dara amra nav er code tike navigation.jspf theke an6i-->
<%@ include file="common/navigation.jspf" %>

<!-- this is for navigation bar -->
<!--  
<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	<a class="navbar-brand m-1" href="https://www.google.com">Google</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="/">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/todos-list">Todos</a>
			</li>
		</ul>
	</div>
	<ul class="navbar-itam">
		<li class="nav-item">
				<a class="nav-link" href="/logout">Logout</a>
			</li>
	</ul>
</nav>
-->

<div class="cointainer">
	<!--  <div>${todos}</div>-->
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th>Delete</th>
				<th>Update</th>
			
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- eti add todo boton er jonno -->
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>	

<!-- eti ke bole jsp fragments . er dara amra nav er code tike footer.jspf theke an6i-->
<%@ include file="common/footer.jspf" %>

<!-- 	<!-- er dara amra bootstrap and jQuery er JavaScript add kor6i  --
<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.3/jquery.min.js"></script> -->

</body>
</html>