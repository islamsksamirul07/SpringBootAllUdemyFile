<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div>Hi, User</div>
	<div>${error}</div>
	<form method="post">
		Name : <input type="text" name="name">
		Password : <input type="password" name="password">
		<button>Submit</button>
	</form>
</body>
</html>