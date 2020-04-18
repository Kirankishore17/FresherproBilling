<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Product Entry</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<style>
	a{
	color:white;
	text-decoration:none;
	}
	form{
	padding:0;
	margin:0;
	}
	</style>	
</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Home</a>
    </div>
    <ul class="nav navbar-right ">
      <li class="navbar-brand mt-2"><a href="/entry">Product Entry</a> </li>
      <li class="navbar-brand mt-2"><a href="/bill"> Billing</a></li>
    </ul>
  </div>
</nav>
<br><br><br>
<div class="container">

	<h3>All Products Available:</h3>
	<table class="table table-hover tableheight">
	
	<tr class="thead-light">
		<th>Code</th>
		<th>Name</th>
		<th>Price</th>
		<th>GST (in %)</th>
		<th>Action</th>
	</tr>
	<tbody>
	
	<c:forEach var="product" items="${list}" >
		<tr class="rowheight">
		<td>${product.code}</td>
		<td>${product.name}</td>
		<td>${product.price}</td>
		<td>${product.gst}</td>
		<td><form action="delete/${product.code}" method="POST"><input type="submit" class="btn btn-secondary btn-sm" value="Delete"></form></td>
		</tr>
	</c:forEach>	
	
	</tbody>	
	</table>
	<hr>
	
	</div>

</body>
</html>