<div class="container">
	<div class="row mb-5">
		<div class="col-lg-12 mt-5">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/projects">Projects</a></li>
				<li class="breadcrumb-item active">${project.projectName}</li>
			</ol>
		</div>
		
		
		<div class="col-lg-6 mt-3">
			<div class="thumbnail">
				<img id="singlePageProjectImage" src="${images}/${project.code}.jpg"
					class="img img-responsive" />
			</div>
		</div>
		
		
		<div class="col-lg-6 mt-3">

			<h6>${project.projectName}</h6>
			<hr />
			<h6>${project.client}</h6>
			<hr />
			<h6>${project.description}</h6>
			<hr />
			<h6>${project.value}</h6>
			<hr />
			<h6>${project.contactDetails}</h6>
			<hr />
			<h6>${project.status}</h6>
			<hr />
            
			<a href="${contextRoot}/all/projects" class="btn btn-success">PROJECTS</a>

		</div>
		
	</div>
</div>