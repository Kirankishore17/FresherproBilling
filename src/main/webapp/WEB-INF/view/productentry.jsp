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
	<h3>Product Entry Form:</h3>
	<form class="form-horizontal" >
	  <div class="form-group">
	    <label for="code" class="control-label col-sm-2">Code:</label>
	    <div class="col-sm-10"><input type="text" class="form-control" id="code"></div>
	  </div>
	  <div class="form-group">
	    <label for="name" class="control-label col-sm-2">Name:</label>
	    <div class="col-sm-10"><input type="text" class="form-control" id="name"></div>
	  </div>
	  <div class="form-group">
	    <label for="price" class="control-label col-sm-2">Price:</label>
	    <div class="col-sm-10"><input type="number" class="form-control" id="price"></div>
	  </div>
	  <div class="form-group">
	    <label for="gst" class="control-label col-sm-2">GST:</label>
	    <div class="col-sm-10"><input type="number" class="form-control" id="gst"></div>
	  </div>
	  <div class="form-group">
	  	<div class="col-sm-10"><button type="submit" class="btn btn-default">Submit</button></div>
	  </div>
	</form>
	<br>
	
</div>
</body>
</html>
