<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<html>
<head>
	<title>Product Entry</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<style>
	a{
	color:white;
	text-decoration:none;}
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
	<h3>Product Entry Form:</h3>
	<form:form cssClass="form-horizontal" action="formSubmit" modelAttribute="product">
	  <div class="form-group">
	    <label for="code" class="control-label col-sm-2">Code:</label>
	    <div class="col-sm-10"><form:input type="number" cssClass="form-control" path="code"></form:input></div>
	  </div>
	  <div class="form-group">
	    <label for="name" class="control-label col-sm-2">Name:</label>
	    <div class="col-sm-10"><form:input type="text" cssClass="form-control" path="name"></form:input></div>
	  </div>
	  <div class="form-group">
	    <label for="price" class="control-label col-sm-2">Price:</label>
	    <div class="col-sm-10"><form:input type="number" cssClass="form-control" path="price"></form:input></div>
	  </div>
	  <div class="form-group">
	    <label for="gst" class="control-label col-sm-2">GST:</label>
	    <div class="col-sm-10"><form:input type="number" cssClass="form-control" path="gst"></form:input></div>
	  </div>
	  <div class="form-group">
	  	<div class="col-sm-10"><input type="submit" class="btn btn-success" value="Submit"></input></div>
	  </div>
	</form:form>
	<br>
	
</div>
</body>
</html>
