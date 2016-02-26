<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit currency</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="/resources/core/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>

<body>

	<div class="col-sm-5 form-box">
		<div class="form-top">
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>
		<form:form action="/currency/edit" method="POST">
		<div class="form-bottom">
			<form role="form" action="" method="post" class="registration-form">
				<div class="form-group">
					<h5>Currency</h5>
					<input type="text" name="name" value="${currency.name}"	class="form-first-name form-control" id="form-first-name">
				</div>
				<div class="form-group">
					<h5>Buy</h5>
					<input type="text" name="buy" value="${currency.buy}"
						class="form-last-name form-control" id="form-last-name">
				</div>
				<div class="form-group">
					<h5>Sell</h5>
					<input type="text" name="sell" value="${currency.sell}"
						class="form-email form-control" id="form-email">
				</div>
				<input type="hidden" name="id"  value="${currency.id}"> 
				<input type="submit" class="btn" value="Save changes" />
			</form>
		</div>
		</form:form>
	</div>

	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/retina-1.1.0.min.js"></script>
	<script src="assets/js/scripts.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

</html>