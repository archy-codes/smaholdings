<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-lg-12" id="project-top-section-image"
			style="background-image:url('${images}/project-top-best.jpg');">
			<div class="col-lg-12 col-xl-12  text-secondary"
				id="services-section">
				<h2 class="text-white font-weight-bolder mb-5">
					<strong>"Quality is Our Priority"<br /></strong>
				</h2>

				<p class="text-secondary font-weight-bold mb-5">We do all kinds
					of constructions ,building services , Logistics , Catering and
					Events Managements Projects</p>
			</div>
			<div class="col-lg-4 offset-lg-6 col-xl-4">
				<a class="btn btn-md btn-primary btn-block mr-5"
					id="services-button" href="${contextRoot}/contact"><strong>Request
						Quote</strong></a>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h5 class="text-secondary">
				<strong> Check Out Our Projects</strong>
			</h5>
		</div>
		<div class="col-lg-3 side-bar-menu-project">
			<%@include file="./shared/sidebar.jsp"%>

			<div class="side-bar-project-sec border text-center border-muted">
				<a class="btn btn-block mt-5 font-weight-bold sidebutton"
					href="${contextRoot}/show/all/blogs">News letter</a>
				
				<a class="btn btn-block mt-5 font-weight-bold sidebutton"
					href="${contextRoot}/contact">Contact Us</a>

                <h6 class=" text-white mt-3 font-weight-bolder text-center">Get Social:</h6>
                <a class="soci" href="#"><i id="social" class="fab fa-twitter ml-3"></i></a>
                <a class="soci" href="#"><i id="social" class="fab fa-instagram ml-3"></i></a>
                <a class="soci" href="#"><i id="social" class="fab fa-facebook-f ml-3"></i></a> 
                <a class="soci" href="#"><i id="social" class="fab fa-linkedin-in ml-3"></i></a>
			</div>


		</div>

		<div class="col-lg-9">
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClicksProjects == true }">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Projects</li>
						</ol>
					</c:if>

					<c:if test="${userClicksCategoryProjects == true}">

						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item">Project</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<!-- here comes our project info -->
			<div class="row">
				<div class="col-lg-12 col-xl-12 col-md-12 mb-5">
					<table id="projectListTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th></th>
								<th>Projects</th>
								<th>Clients</th>
								<th>Description Of Works</th>
								<th>Value</th>
								<th>contact details</th>
								<th>status</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Projects</th>
								<th>Clients</th>
								<th>Description Of Works</th>
								<th>Value</th>
								<th>contact details</th>
								<th>status</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>

				<div class="col-lg-12 mb-5 mt-5"
					style="height:300px; background-image:url('${images}/project-bottom-pictures.jpg');">

				</div>
			</div>
		</div>
	</div>
</div>







