<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Product Entry</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Home</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/entry"><span class="glyphicon glyphicon-user"></span>Product Entry</a></li>
      <li><a href="/bill"><span class="glyphicon glyphicon-log-in"></span>Billing</a></li>
    </ul>
  </div>
</nav>

<div class="container">

	<h3>Products:</h3>
	<table class="table table-hover">
	<tr>
		<th>Code</th>
		<th>Name</th>
		<th>Price</th>
		<th>GST (in %)</th>
	</tr>
	<c:forEach var="product" items="${list}">
		<tr>
		<td>${product.code}</td>
		<td>${product.name}</td>
		<td>${product.price}</td>
		<td>${product.gst}</td>
		</tr>
	</c:forEach>	
	</table>
	<br>
	<hr>
	<br>
	</div>

</body>
</html>