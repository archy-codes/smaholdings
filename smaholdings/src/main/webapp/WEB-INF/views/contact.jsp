
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${js}/angular.js"></script>
<script src="${js}/angular.js"></script>

<div class="col-lg-12 col-xl-12 text-primary"
	style=" height:400px; background-image:url('${images}/mbulu1.jpg');">
	<h1 class="font-weight-bolder"
		style="position: absolute; margin: 150px;">How to find us?</h1>
</div>
<div class="container">
	<div class="row">
	  
	      <c:if test="${not empty message}">
	          <div class="col-lg-12">
	             <div class="alert alert-success alert-dismissible">
	                 <button type="button" class="close" data-dismiss="alert">&times;</button>
	                 ${message}
	             </div>
	          </div>
	      </c:if>
	
		<div class="col-lg-6 mt-5 mb-5 offset-lg-1">
			<div class="card border-0" style="background-color:rgb(211,211,211,0.02)">
			  <div class="card-header border-bottom" style="background-color:rgb(211,211,211,0.02)">
			     <h4 class="text-center">Contact us</h4>
			  </div>
				<div class="card-body">
					<!-- form elemets -->
					<sf:form class="form-horizontal" modelAttribute="contact" action="${contextRoot}/contact" method="POST">

						<div class="row">
							<label class="control-label text-center col-lg-4 col-xl-4"
								for="fname">Enter Your First Name: </label>
							<div class="col-lg-8 col-xl-8">
								<sf:input type="text" path="fname" id="fname"
									placeholder="Enter first Name here" class="form-control" />
							  <sf:errors path="fname" cssClass="help-block" element="em" />
 							</div>
						</div>
						<div class="row mt-3">
							<label class="control-label text-center col-lg-4 col-xl-4"
								for="lname">Enter Your Last Name: </label>
							<div class="col-lg-8 col-xl-8">
								<sf:input type="text" path="lname" id="lname"
									placeholder="Enter Last Name here" class="form-control" />
									<sf:errors path="fname" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="row mt-3">
							<label class="control-label text-center col-lg-4 col-xl-4"
								for="email">Enter Your Email Here: </label>
							<div class="col-lg-8 col-xl-8">
								<sf:input path="email" name="email" id="email"
									placeholder="aluwani@smaholdings.co.za" class="form-control" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="row mt-3">
							<label class="control-label text-center col-lg-4 col-xl-4"
								for="description">Enter Your query Here: </label>
							<div class="col-lg-8 col-xl-8">
								<sf:textarea path="description" rows="5" id="description"
									placeholder="type your query here" class="form-control"/>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="row mt-3">
							<label class="control-label text-center col-lg-4 col-xl-4"
								for="categoryId">Select query related options: </label>
							<div class="col-lg-8 col-xl-8">
								<sf:select path="categoryId" id="categoryId" class="form-control"
								   items="${categories}"
								   itemLabel="name"
								   itemValue="id" 
								 />
							</div>
						</div>

						<div class="row mt-3">

							<div class="col-lg-8 offset-lg-4 col-xl-8 offset-xl-4">
								<input type="submit" name="submit" id="submit"
									class=" btn form-control" style="border:1px solid gray" />
									
									<sf:hidden path="id"/>
									<sf:hidden path="active"/>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
				
		</div>
		
		
					<!-- here comes the address -->
				<div class="col-lg-4 mt-5">
					<div class="card border-0 ml-5" style="background-color:rgb(211,211,211,0.01)">
						<div class="card-header border-bottom" style="background-color:rgb(211,211,211,0.01)">
							<h4>Information</h4>
						</div>
						<div class="card-body text-muted" style="background-color:rgb(211,211,211,0.02)">
						   <h5>
								<i class="fas fa-map-marker-alt footer-icons"> </i>
										O5 Peolwana Street, <span class="ml-4">Rethabile Gardens,</span><br/><span class="ml-4">Polokwane</span>
							</h5><br/>
							<h5>
								<i class="fas fa-envelope-open-text"></i>
										P O BOX 135 , Muwaweni ,<br/><span class="ml-4">0949</span>
							</h5><br/>
							<h5>
								<i class="fas fa-mobile-alt"></i>
										078 814 9528 <br/> <span class="ml-4">/086 212 3462</span>
							</h5><br/>
							<h5>
								<a href="#"><i class="fas fa-paper-plane"></i>
											aluwani@smaholdings.co.za</a>
							</h5>
						</div>
					</div>
				</div>
			<!-- end address -->

	</div>
</div>





















