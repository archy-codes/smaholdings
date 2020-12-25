<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SMA Business Enterprice- ${title}</title> 


<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- readable theme bootstrap -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet" />

<!-- font awesome -->
<link href="${css}/all.css" rel="stylesheet">

<!-- Custom styles for this template -->

<link href="${css}/jquery.dataTables.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper" id="loginsection" style="background-image:url('${images}/logbackground.jpg');">

		<!-- navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home"><img id="logoBackend" src="${images}/logoarchy.png" class="image-fluid" style="width:200px; height:80px;" /></a>
				</div>
			</div>
		</nav>
		<!-- container -->
		<div class="content">
			<div class="container pb-5" >

				<!-- display only when the credits are wrong -->
				<c:if test="${not empty message}">
					<div class="row">
						<div class="col-lg-6 offset-lg-3">
							<div class="alert alert-danger">${message}</div>
						</div>
					</div>
				</c:if>


				<div class="row">
					<div class="col-lg-6 offset-lg-3 mt-5">
						<div class="card card-primary mt-5 border-primary mt-5" id="about-us-shadow-about-section" style="height:300px;">
						   
							<div class="card-header bg-white border-0">
							   <i class="fas fa-user-circle text-primary" style=" position:absolute; width:300px; height:100px; top:-55px; left:130px;"></i>
								<h6 class="font-weight-bold text-primary">LOGIN</h6>
							</div>
							<div class="card-body">

								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">
                                   
									<div class="form-group">
									<div class="row">
										<label for="username" class="col-lg-4 mt-3 control-label">Enter
											Email:</label>
										<div class="col-lg-8">
											<input type="text" name="username" id="username" placeholder="enter email username"
												class="form-control mt-3" />
										</div>
									</div>
									</div>


                                    
									<div class="form-group">
									<div class="row">
										<label for="password" class="col-lg-4 mt-3 control-label">Enter
											Password:</label>
										<div class="col-lg-8">
											<input type="password" name="password" id="password" placeholder="password"
												class="form-control mt-3" />
										</div>
										</div>
									</div>
                                   
                    

									<div class="col-lg-8 offset-lg-4">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" /> 
																						
											<input type="submit" value="Login"
											class="btn btn-primary font-weight-bolder mt-3"  />
										
											
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/all.js"></script>
		<script src="${js}/jquery.waypoints.min.js"></script>
		<script src="${js}/jquery.counterup.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>
		<script src="${js}/bootbox.min.js"></script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>

