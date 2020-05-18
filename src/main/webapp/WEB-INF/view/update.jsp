<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>

<html>
<head>
	<title>Fresherpro Billing App</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<style>
	a{
	color:white;
	text-decoration:none;
	}
	a:hover {
	color:white;
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
      <li class="navbar-brand mt-2 "><a href="/entry">Product Entry</a> </li>
      <li class="navbar-brand mt-2 "><a href="/bill"> Billing</a></li>
    </ul>
  </div>
</nav>
<br><br><br>

<div class="container">
	<h3>Update Product Details:</h3>
	<form class="form-horizontal" action="product" method="post">
	  <div class="form-group">
	    <label for="code" class="control-label col-sm-2">Code:</label>
	    <div class="col-sm-10"><input class="form-control" name="code" value="${code}" ></input></div>
	  </div>
	  <div class="form-group">
	    <label for="name" class="control-label col-sm-2">Name:</label>
	    <div class="col-sm-10"><input class="form-control" name="name" value="${name}"></input></div>
	  </div>
	  <div class="form-group">
	    <label for="price" class="control-label col-sm-2">Price:</label>
	    <div class="col-sm-10"><input  class="form-control" name="price" value="${price}"></input></div>
	  </div>
	  <div class="form-group">
	    <label for="gst" class="control-label col-sm-2">GST:</label>
	    <div class="col-sm-10"><input class="form-control" name="gst" value="${gst}"></input></div>
	  </div>
	  <div class="form-group">
	  	<div class="col-sm-10"><input type="submit" class="btn btn-success" value="Update"></input></div>
	  </div>
	</form>
	<br>	
</div>
</body>
</html>
