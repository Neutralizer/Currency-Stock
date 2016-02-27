<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" href="/resources/core/css/bootstrap.min.css">
<link rel="stylesheet" href="/font-awesome/3.2.1/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h3>Currency Table</h3>
			</div>
		</div>
		<form:form action="/currency" method="POST">
			<%-- <div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<input type="search" id="search" value="${searchedValue}"
						name="name" class="form-control" placeholder="Search for currency">
				</div>
				<input type="submit" class="btn" value="Search" />

			</div> --%>
			<div class="col-lg-4 col-lg-offset-4">
				<div class="input-group">
					<input type="text" class="form-control" name="name" value="${searchedValue}" placeholder="Search for currency">
					<span class="input-group-btn">
						<input class="btn btn-default" type="submit" value="Search"/>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->

		</form:form >
		<div class="row">
			<div class="col-lg-12">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>Currency</th>
							<th>Buy</th>
							<th>Sell</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${currencyList}" var="currency">
							<tr>
								<td>${currency.name}</td>
								<td>${currency.buy}</td>
								<td>${currency.sell}</td>
								<td>
									<button class="btn btn-primary"
										onclick="location.href='/currency/edit?id=${currency.id}'">Edit</button>
									<button class="btn btn-danger"
										onclick="location.href='/currency/delete?id=${currency.id}'">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
			</div>
		</div>
		<button class="btn btn-primary"
			onclick="location.href='/currency/add'">Add Currency</button>
	</div>



	<script src="/dist/jquery.searchable-1.0.0.min.js"></script>
</body>
</html>