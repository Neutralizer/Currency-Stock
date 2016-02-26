<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="/resources/core/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/font-awesome/3.2.1/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h3>Stock Table</h3>
			</div>
		</div>
		<form action="/stock/" method="POST">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<input type="search" id="search" value="${searchedValue}"
						name="name" class="form-control" placeholder="Search for stock">
				</div>
				<input type="submit" class="btn" value="Search" />
			</div>
		</form>
		<div class="row">
			<div class="col-lg-12">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>Stock</th>
							<th>Buy</th>
							<th>Sell</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stockList}" var="stock">
							<tr>
								<td>${stock.name}</td>
								<td>${stock.buy}</td>
								<td>${stock.sell}</td>
								<td>
									<button class="btn btn-primary"
										onclick="location.href='/stock/edit?id=${stock.id}'">Edit</button>
									<button class="btn btn-danger"
										onclick="location.href='/stock/delete?id=${stock.id}'">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
			</div>
		</div>
		<button class="btn btn-primary" onclick="location.href='/stock/add'">Add
			Stock</button>
	</div>



	<script src="/dist/jquery.searchable-1.0.0.min.js"></script>
</body>
</html>