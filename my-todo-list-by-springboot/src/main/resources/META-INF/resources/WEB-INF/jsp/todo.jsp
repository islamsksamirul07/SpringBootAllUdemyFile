<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- eti ke bole jsp fragments . er dara amra nav er code tike Header.jspf theke an6i-->
<%@ include file="common/header.jspf" %>

<!-- <!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Describe your Details</title> -->
<!-- er dara amra bootstrap er css add kor6i -->
<link href="webjars/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
<!--  this is for add new date format-->
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">

</head>
<body>


<!-- eti ke bole jsp fragments . er dara amra nav er code tike navigation.jspf theke an6i-->
<%@ include file="common/navigation.jspf" %>

<!--
<!-- this is for nagivation bar >
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


<div class="containers">
<h2>Enter your details :</h2>
<!--  <form method="post">
	Description : <input type="text" name="description" required="required">
	<button type="submit" class="btn btn-success">Submit</button>
</form>

</div>
-->
<form:form method="post" modelAttribute="todo">
<fieldset>
	<form:label path="description">Description : </form:label>
	<form:input type="text" path="description" required="required"/>
	<!-- er dara amra @size je message ti likhbo seti display hobe -->
	<form:errors path="description" cssClass="text-warning"/>
</fieldset>

<fieldset>
	<form:label path="targetDate">Target Date : </form:label>
	<form:input type="text" path="targetDate" required="required"/>
	<!-- er dara amra @size je message ti likhbo seti display hobe -->
	<form:errors path="targetDate" cssClass="text-warning"/>
</fieldset>

	<form:input type="hidden" path="id"/>
	
	<form:input type="hidden" path="done"/>
	
	<button type="submit" class="btn btn-success">Submit</button>
</form:form>


<!-- eti ke bole jsp fragments . er dara amra nav er code tike footer.jspf theke an6i-->
<%@ include file="common/footer.jspf" %>

<!-- <!-- er dara amra bootstrap and jQuery er JavaScript add kor6i  
<script src="webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.3/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script> -->
<!-- this is for add style on on date form -->
<script type="text/javascript">
$('#targetDate').datepicker({
	format:"dd-mm-yyyy",
	startDate:'-3'
});
</script>

</body>
</html>