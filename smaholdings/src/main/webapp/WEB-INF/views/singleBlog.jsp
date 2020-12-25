<div class="container-fluid">
	<div class="row">
		<div class="col-lg-12 mt-5">
			<ol class="breadcrumb bg-white">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/blogs">blogs</a></li>
				<li class="breadcrumb-item active">${blog.name}</li>
			</ol>
		</div>


		<div class="col-lg-4 offset-lg-2 mt-3">
			
				<img id="singlePageProjectImage" src="${images}/${blog.code}.jpg"
					class="img img-responsive" />

       </div>
       <div class="col-lg-4 offset-lg-1 mt-5">
		<div class="card border-0 mt-3">

			<h6 class="font-weight-bold">${blog.name}</h6>
			<hr />
			<h6>${blog.description}</h6>
			<hr />
			<h6>${blog.blogdate}</h6>
			<hr />
			<a href="${contextRoot}/show/all/blogs" class="btn btn-success">all blogs</a>

		</div>


	</div>
</div>
</div>