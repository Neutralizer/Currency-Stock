<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="/resources/core/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/font-awesome/3.2.1/css/font-awesome.min.css">
</head>
<body>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<div class="container">
		<div class="row">
			<div class="col-lg-5 col-lg-offset-3" align="center">
				<h3>You are logged in!</h3>
			</div>
		</div>

		<br> <br>

		<div class="col-lg-4 col-lg-offset-4" align="center">
			<button class="btn btn-primary" onclick="location.href='/currency/'">Currency</button>
			<button class="btn btn-primary" onclick="location.href='/stock/'">Stock</button>
		</div>
		<div class="col-lg-4 col-lg-offset-4" align="center">
			<button class="btn btn-danger"
				onclick="location.href='javascript:formSubmit()'">Logout</button>
		</div>
	</div>
	<script src="/dist/jquery.searchable-1.0.0.min.js"></script>
</body>
</html>