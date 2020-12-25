<!-- Page Content -->
<script src="${js}/angular.js"></script>

<script src="${js}/myangular.js"></script>
<%@include file="header.jsp"%>

<div class="container-fluid">


	<!-- about us section landing page-->
	<div class="row">

		<!-- <div class="col-lg-12  col-xl-12 mt-5 main-section-about-company">-->

		<!--<div class="row">-->

		<div class="col-lg-11 offset-lg-1 mt-5 text-primary"
			id="about_us_left_border">
			<h2 class="font-weight-bolder">About Sma Business Enterprice</h2>
		</div>
		<div class="col-lg-12">
		<h4 class="text-muted text-center mt-5 mb-5 font-weight-bolder">"A
				Multi-disciplinary company"</h4>
		</div>
		<div class="col-lg-6 offset-lg-1 mb-5  mt-5  main-section-about-info">

			<div class="card mt-2 mb-5">
				<div class="card-body">
					<p>
						<span><strong>SMA Business Enterprice (Pty)Ltd</strong></span> is
						a professional innovative company having a qualified Chief
						Executive Officer within the company. The company was originated
						in South Africa in 2013 and is owned with 100% BBE shareholding
						making our company the black owned company.
					</p>

					<p>Our company provides quality services and reliability, for
						providing good services to our clients and recipient. The company
						was founded to assist all the Stakeholders (All forms of
						Government, Private Sector, Parastatals, NGO's etc) to deliver
						infrastructure projects and Supply of water, sewer, steel pipes
						and fittings.</p>

					<p>In addition, the company acts as a role model to aspiring
						young engeneers, technicians, and all other technically qualified
						persons in South Africa. SMA Business Enterprice(Pty)Ltd is a
						company totally committed to the achievement and maintenance of
						excellence. We create unique solutions, whilst also touching
						everybody's lives.</p>
				</div>

			</div>


		</div>

		<div class="col-lg-4 mt-2 acodi-lading-page">
			<div id="accordionExample" class="bg-white mt-5">
				<!-- Accordion item 1 -->
				<div class="card bg-white ">
					<div id="headingTwo" class="card-header bg-white border-0">
						<h6 class="mb-0 font-weight-bold">
							<a href="#" data-toggle="collapse" data-target="#collapseTwo"
								aria-expanded="true" aria-controls="collapseTwo"
								class="d-block position-relative collapsed text-muted  collapsible-link">Our
								Mission Statement</a>
						</h6>

					</div>
					<div id="collapseTwo" aria-labelledby="headingTwo"
						data-parent="#accordionExample" class="collapse show">
						<div class="card-body">
							<p>
								To complete all our projects in a highest quality, safety and on
								time;<br /> To contribute on growth and development of
								surrounding communities.
							</p>
						</div>
					</div>
				</div>


				<div class="card bg-white">
					<div id="headingThree" class="card-header bg-white border-0">
						<h6 class="mb-0 font-weight-bold">
							<a href="#" data-toggle="collapse" data-target="#collapseThree"
								aria-expanded="false" aria-controls="collapseThree"
								class="d-block position-relative collapsed text-muted  collapsible-link">Our
								Vision Statement </a>
						</h6>
					</div>
					<div id="collapseThree" aria-labelledby="headingThree bg-white"
						data-parent="#accordionExample" class="collapse">
						<div class="card-body">
							<p>To be the leading company that promotes good and quality,
								and provides better service of an international standard, this
								is relevant to the needs and aspirations of South African
								people.</p>
						</div>
					</div>
				</div>

				<div class="card">
					<div id="heading6" class="card-header bg-white border-0">
						<h6 class="mb-0 font-weight-bold">
							<a href="#" data-toggle="collapse" data-target="#collapse6"
								aria-expanded="false" aria-controls="collapse6"
								class="d-block position-relative collapsed text-muted  collapsible-link">
								Management &amp; Ownership </a>
						</h6>
					</div>
					<div id="collapse6" aria-labelledby="heading6"
						data-parent="#accordionExample" class="collapse">
						<div class="card-body">
							<h6 class="font-weight-bold text-muted">1.Ownership
								Structure</h6>
							<p>SMA Business Enterprises (Pty) Ltd is 100% wholly owned by
								Aluwani Clavens Mulaudzi, see shareholding for more details.</p>


							<h6 class="font-weight-bold text-muted">2.our director</h6>
							<p>Mr. Aluwani Clavens Mulaudzi</p>
						</div>
					</div>
				</div>

				<div class="card">
					<div id="headingFour" class="card-header bg-white border-0">
						<h6 class="mb-0 font-weight-bold">
							<a href="#" data-toggle="collapse" data-target="#collapseFour"
								aria-expanded="false" aria-controls="collapseFour"
								class="d-block position-relative collapsed text-muted  collapsible-link">Our
								Objectives</a>
						</h6>
					</div>
					<div id="collapseFour" aria-labelledby="headingFour"
						data-parent="#accordionExample" class="collapse">
						<div class="card-body">
							<p>
								To provide the best quality service to our clients at best
								rates. <br /> To act professionally and with integrity in all
								our business dealings. <br /> To promote black economic
								empowerment at all times. <br /> To create job opportunities
								for the youth in South Africa. <br /> To be one of the leading
								developmental practice in the continent and abroad.
							</p>
						</div>
					</div>
				</div>

			</div>
		</div>
		
		<div
			class="col-lg-4 col-xl-4 offset-xl-4 offset-lg-4 findMoreAboutUsButton-info">
			<a id="findMoreMoreButton" class="btn btn-block"
				href="#"><strong class="font-weight-bold text-primary hover-me">About us</strong></a>
		</div>
	
		

		<div class="col-lg-12">
		    <h2 class="font-weight-bolder text-primary text-center mt-5 mb-5">Our Services</h2>
			<%@include file="./shared/Services-section.jsp"%>
		</div>

		<!--</div>  -->
		<!-- </div> -->



	</div>
	</div>
	<div class="container mb-5" ng-app="webApp"
	ng-controller="controllerP as gloController">
	<div class="row" ng-init="gloController.fetchData()">
		<div class="col-lg-12 mt-5 mb-5">
			<h2 class="font-weight-bolder text-primary text-center">Our
				latest Projects</h2>
		</div>


		<div class="col-lg-3 mt-5"
			ng-repeat="project in gloController.latestPro"
			style="content: center; width: 400px; margin-left: 80px;">
			<img src="${images}/project.jpg" alt=""
				style="width: 100%; height: 200px;">
			<div class="caption mt-3">
				<h5 class="font-weight-bold text-muted">{{project.projectName}}</h5>
				<p>{{project.description}}</p>
				<p class="text-center blog-more-info">
				       <!-- on click must go to sing;le page blog -->
						<a ng-href="#">More Info</a>
				</p>
			</div>
		</div>

		
	     <div
			class="col-lg-4 col-xl-4 offset-xl-4 offset-lg-4 mb-5 mt-5 findMoreServicesUsButton-info">
			<a id="findMoreServicesUsButton" class="btn btn-md btn-block  mt-4"
				ng-href="${contextRoot}/all/projects"><strong class="font-weight-bold text-primary">More Projects</strong></a>
		</div>
		
		

		<!-- project and clients show section -->
		<%@include file="./shared/showProject.jsp" %>

		<div class="col-lg-12 mt-5">
			<h2 class="font-weight-bolder text-primary text-center">Our
				latest Blogs</h2>
		</div>



		<div class="col-lg-3 mt-5"
			ng-repeat="blog in gloController.latestBlog"
			style="content: center; width: 400px; margin-left: 80px;">
			<img src="${images}/training.jpg" alt=""
				style="width: 100%; height: 200px;">
			<div class="caption mt-3">
				<h5 class="font-weight-bold text-muted">{{blog.name}}</h5>
				<p>{{blog.description}}</p>
				<p class="text-center blog-more-info">
					<a href="#">More Info</a>
				</p>
			</div>
		</div>
		
	    <div
			class="col-lg-4 col-xl-4 offset-xl-4 offset-lg-4 mb-5 mt-5 findMoreServicesUsButton-info">
			<a id="findMoreServicesUsButton" class="btn btn-md btn-block  mt-4"
				ng-href="${contextRoot}/show/all/blogs"><strong class="font-weight-bold text-primary">More Blogs</strong></a>
		</div>

	</div>

</div>