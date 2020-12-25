<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>SMA Business Enterprice - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<link href="${css}/lightbox.min.css" rel="stylesheet">

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
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- container -->
		<div class="content">

			<c:if test="${userClicksHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClicksAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClicksServices == true}">
				<%@include file="services.jsp"%>
			</c:if>

			<c:if test="${userClicksContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<c:if
				test="${userClicksProjects == true or userClicksCategoryProjects == true}">
				<%@include file="projects.jsp"%>
			</c:if>

			<c:if
				test="${userClicksBlogs == true or userClicksCategoryBlogs == true}">
				<%@include file="blog.jsp"%>
			</c:if>
			<c:if test="${userClickShowProject == true}">
				<%@include file="singleProject.jsp"%>
			</c:if>
			<c:if test="${userClickManageProjects == true}">
				<%@include file="manageProjects.jsp"%>
			</c:if>
			
			<c:if test="${userClicksGallery == true }">
				<%@include file="gallery.jsp"%>
			</c:if>
			<c:if test="${userClickLinkNewPage == true}">
				<%@include file="singlePageServices.jsp"%>
			</c:if>
			<c:if test="${userClickShowBlog == true }">
			   <%@include file="singleBlog.jsp" %>
			</c:if>
			
			<c:if test="${userClickMoreServices == true}">
			   <%@include file="./shared/serviceSection.jsp" %>
			</c:if>
			<c:if test="${userClicksTheCategoryService == true}">
			   <%@include file="./shared/Services-section.jsp" %>
			</c:if>

		</div>
		<!-- Footer -->
		
<%@include file="./shared/topfooter.jsp"%> 
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/lightbox-plus-jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/all.js"></script>
		<script src="${js}/jquery.waypoints.min.js"></script>
		<script src="${js}/jquery.counterup.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>
		<script src="${js}/bootbox.min.js"></script>
		<script>
		    function initMap()
		</script>
		<script defer
			 src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbthoz5bj0sIhTEa1rcPAoTjS3G4YISl4&callback=initMap">
		</script>
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>

