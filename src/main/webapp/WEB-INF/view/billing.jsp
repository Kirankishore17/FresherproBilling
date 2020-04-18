<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Product Entry</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<style>
	a{
	color:white;
	text-decoration:none;}
	.qty{
	padding:0;
	margin:0;}
	</style>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/">Home</a>
	    </div>
	    <ul class="nav navbar-right ">
	      <li class="navbar-brand mt-2 "><a href="/entry">Product Entry</a> </li>
	      <li class="navbar-brand mt-2 "><a href="/bill"> Billing</a></li>
	    </ul>
	  </div>
	</nav>
	<br><br><br>
	<div class="container">
		<div class="alert alert-info">No charges 100% OFF (Corona offer)</div>
		
		<form action="addtobillId" method="post">
		  <div class="form-row">
		    <div class="col">
		      <input type="number" class="form-control form-control-sm" placeholder="Search by Code" name="id">
		     </div>
		     <div>
		      <input type="number" class="qty" placeholder="Qty" value="1" name="qty" min="1" max="50">
		    </div>
		    <div class="col">
		      <input type="submit" class="btn btn-success btn-sm" value="Search Code">
		    </div>	    
		  </div>
		 </form>
		 
		  <form method="post" action="addtobillName">
		  <div class="form-row">
		    <div class="col">
		      <input type="text" class="form-control form-control-sm" placeholder="Search by Name" name="name">
		      </div>
		     <div>
		     <input type="number"  class="qty" placeholder="Qty" value="1" name="qty" min="1" max="50">
		    </div>
		    <div class="col">
		      <input type="Submit" class="btn btn-success btn-sm" value="Search Name">
		    </div>
		  </div>
		</form>
		
		<table class="table table-hover">
		<tr class="thead-light">
			<th>Code</th>
			<th>Name</th>
			<th>Price</th>
			<th>GST (in %)</th>
			<th>Quantity</th>
			<th>Amount</th>
		</tr>
		<c:forEach var="product" items="${billList}">
			<tr class="rowheight">
			<td>${product.code}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.gst}</td>
			<td>${product.qty}</td>
			<td>${product.amount}</td>
			</tr>
		</c:forEach>	
		</table>
		<form action="clear" method="post">
		      <input type="submit" class="btn btn-primary btn-sm" value="Reset">		
		</form>
		
		<div class="container">
			<h4>Total: <c:out value="${total}"/></h4>
		</div>
	</div>
</body>
</html>
