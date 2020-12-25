<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Page Content -->

<div class="container-fluid">
	<div class="row"
		style="background-image: url('${images}/blog.jpg'); height:350px; filter: blur(6px);">

	</div>
	<div class="row">
		<div class="col-lg-6 "
			style="position: absolute; top: 300px; left: 250px; background-color: rgb(0, 0, 0); background-color: rgba(0, 0, 0, 0.4); z-index: 2;">
			<h3 class="font-weight-bold text-white text-center">Sma Business
				Enterprice News</h3>
		</div>
	</div>
</div>
<div class="container mt-5">
	<div class="row">
		<!-- blog content starts here -->

		<div class="col-lg-12">


			<c:if test="${userClicksBlogs == true }">

				<script>
					window.blogCategoryId = '';
				</script>

				<ol class="breadcrumb bg-white">
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
					<li class=" breadcrumb-item active">all blogs</li>
				</ol>

			</c:if>




			<c:if test="${userClicksCategoryBlogs == true }">

				<script>
					window.blogCategoryId = '${blogcategory.id}';
				</script>

				<ol class="breadcrumb bg-white">
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
					<li class=" breadcrumb-item">blogcategory</li>
					<li class="breadcrumb-item active">${blogcategory.name}</li>

				</ol>

			</c:if>


		</div>

		<div class="col-lg-8 mt-5 mb-5 mybi">
		<!-- here comes our lates blogs -->
		<h4 class=" font-weight-bold text-secondary mt-5 mb-5">Our latest Blogs</h4>
		    <table class="border border-muted" id="myblog">
                   <thead id="blogtable">
                      <tr>
                        <th></th>
                        <th> Blog heading</th>
                        <th>Blod description</th>
                        <th>blog date</th>
                        <th></th>
                      </tr>
                   </thead>  
            </table>
         </div>
		<!-- Blog Entries Column -->
            

		<!-- Sidebar Widgets Column -->              
		<div class="col-lg-3 offset-lg-1 mb-5" id="myblogsidebar">

			<!-- Search Widget -->

			<!-- Categories Widget -->
			<div class="card my-4 mt-5">
				<h6
					class="card-header font-weight-bold text-center text-secondary bg-white border-0">Categories</h6>
				<div class="card-body" style="justify-content:center;">
						<%@include file="./shared/sideCategoryMenu.jsp"%>
				</div>
			</div>
			<div class="card mt-5 my-social-handle">
			   <h6 class="card-header font-weight-bold text-secondary text-center bg-white border-0">get social</h6>
			    <a class="soci" href="#"><i id="social" class="fab fa-twitter ml-3"></i></a>
                <a class="soci" href="#"><i id="social" class="fab fa-instagram ml-3"></i></a>
                <a class="soci" href="#"><i id="social" class="fab fa-facebook-f ml-3"></i></a> 
                <a class="soci" href="#"><i id="social" class="fab fa-linkedin-in ml-3"></i></a>
			</div>

		</div>
		<!-- Side Widget -->


	</div>

</div>