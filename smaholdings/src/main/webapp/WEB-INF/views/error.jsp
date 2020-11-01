<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SmaHoldings - ${title}</title>
  
  <script>
       window.menu = '${title}';
       window.contextRoot = '${contextRoot}';
  </script>
   

  <!-- Bootstrap core CSS -->
  <link href="${css}/bootstrap.min.css" rel="stylesheet">
  
  <!-- readable theme bootstrap -->
  
  
  <!-- font awesome -->
  <link href="${css}/all.css" rel="stylesheet">
  <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
   <!-- Custom styles for this template -->
   
   <link href="${css}/jquery.dataTables.css" rel="stylesheet">
   
  <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
<div class="wrapper">
  <!-- Navigation -->
 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
       <div class="navbar-header">
           <a href="navbar-brand" href="${contextRoot}/home">Home</a>
       </div>
    </div>
 </nav>
  
  <!-- page content -->
<div class="content">
      <div class="container">
         <div class="row">
           <div class="col-lg-12">
                <!-- displaying the error message -->
                <div class="jumbotron">
                  <div class="row">
                   <div class="col-lg-4 text-danger" >
                   <i class="fas fa-exclamation-triangle" id="errorImage"></i>
                   </div>
                   <div class="col-lg-8">
                   <h1 class="text-danger"><strong>${title}</strong></h1>
                   <h3 class=" text-primary">${ErrorTitle}</h3>
                   <hr/>
                   <blockquote class="text-secondary"> 
                        ${errorDescription} 
                   </blockquote>
                   <h6><strong>${link}</strong> <a href="${contextRoot}/home"><strong class="text-danger">  Click here  </strong></a><strong>to be directed back to the home page</strong></h6>
                   </div>
                   </div>
                </div>
           </div>
         </div>
      </div>
</div>
 
  <!-- Footer -->


  <!-- Bootstrap core JavaScript -->
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.bundle.min.js"></script>
  <script src="${js}/all.js"></script>
  <script src="${js}/jquery.waypoints.min.js"></script>
  <script src="${js}/jquery.counterup.min.js"></script>
  <script src="${js}/jquery.dataTables.js"></script>
  <script src="${js}/dataTables.bootstrap.js"></script>
  <script src="${js}/myapp.js"></script>
</div>
</body>

</html>

