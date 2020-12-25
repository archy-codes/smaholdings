
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container mt-5">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-lg-12 col-xl-12 mt-5">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>


		<div class="col-lg-4 col-xl-12 mt-3">

			<div class="tab-content mb-5">
				<div id="manageProject" class="container tab-pane active">
					<br>
					<div class="card mt-3" id="manageprojectcard">
						<div class="card-header text-center">
							<h5 class="font-weight-bold">manage project</h5>
						</div>
						<div class="card-body">
							<!-- form elements -->
							<sf:form class="form-horizontal" modelAttribute="project"
								action="${contextRoot}/manage/projects" method="POST"
								enctype="multipart/form-data">

								<div class="form-group">
									<div class="row">
										<label class="control-label col-lg-4 col-xl-4"
											for="projectName">Enter project name:</label>
										<div class="col-lg-8 col-xl-8">
											<sf:input type="text" path="projectName" id="projectName"
												placeholder="project name here:" class="form-control" />
											<sf:errors path="projectName" cssClass="help-block"
												element="em" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<label class="control-label col-lg-4 col-xl-4" for="client">Enter
											client name:</label>
										<div class="col-lg-8 colxl-8">
											<sf:input type="text" path="client" id="client"
												placeholder="client name here:" class="form-control" />
											<sf:errors path="client" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<label class="control-label col-lg-4 colxl-4"
											for="contactDetails">Enter client contact:</label>
										<div class="col-lg-8 col-xl-8">
											<sf:input type="text" path="contactDetails"
												id="contactDetails" placeholder="name and contact"
												class="form-control" />
											<sf:errors path="contactDetails" cssClass="help-block"
												element="em" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<label class="control-label col-lg-4" for="value">Enter
											project Value:</label>
										<div class="col-lg-8 col-xl-8">
											<sf:input type="number" path="value" id="value"
												placeholder="R100000" class="form-control" />
											<sf:errors path="value" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<label class="control-label col-lg-4 col-xl-4" for="status">Enter
											project Status:</label>
										<div class="col-lg-8 col-xl-8">
											<sf:input type="text" path="status" id="status"
												placeholder="project status" class="form-control" />
											<sf:errors path="status" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="row">
										<label class="control-label col-lg-4 col-xl-4" for="value">Enter
											project description:</label>
										<div class="col-lg-8 col-xl-8">
											<sf:textarea name="description" path="description" rows="5"
												cols="10" placeholder="project description here"
												class="form-control" />
											<sf:errors path="description" cssClass="help-block"
												element="em" />
										</div>
									</div>
								</div>

								<!-- file element for image -->
								<div class="form-group">
									<div class="row">
										<label class="control-label col-lg-4 col-xl-4" for="file">Select
											an Image</label>
										<div class="col-lg-8 col-xl-8">
											<sf:input type="file" path="file" class="form-control" />
											<sf:errors path="file" cssClass="help-block" element="em" />
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="row">
										<label class="control-label col-lg-4 col-xl-4"
											for="categoryId">Select Category:</label>
										<div class="col-lg-8 col-xl-8">
											<sf:select class="form-control" id="categoryId"
												path="categoryId" items="${categories}" itemLabel="name"
												itemValue="id" />
											<c:if test="${project.id == 0 }">
												<div class="text-right">
													<br />
													<button type="button" data-target="#myModal"
														data-toggle="modal"
														class="btn btn-warning font-weight-bold">Add
														Category</button>
												</div>
											</c:if>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="row">
										<div class="col-lg-12 col-xl-4 offset-xl-4">
											<input type="submit" id="submit" value="submit"
												class="btn btn-success font-weight-bolder" />

											<!-- Hidden fields -->
											<sf:hidden path="id" />
											<sf:hidden path="code" />
											<sf:hidden path="adminId" />
											<sf:hidden path="active" />

										</div>
									</div>
								</div>

							</sf:form>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<h3>available Projects</h3>
			<hr />
		</div>
		<div class="col-lg-12">
			<div style="overflow: auto">
				<table id="adminProjectTable"
					class="table table-stripped table-borderd">
					<thead>
						<tr>
							<th>ID</th>
							<th></th>
							<th>PROJECTS</th>
							<th>CLIENT</th>
							<th>DESCRIPTION OF WORK</th>
							<th>VALUE</th>
							<th>CONTACT_DETAILS</th>
							<th>STATUS</th>
							<th>ACTIVE</th>
							<th>EDIT</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>ID</th>
							<th></th>
							<th>PROJECT_NAME</th>
							<th>CLIENT</th>
							<th>PROJECT_DESCRIPTION</th>
							<th>VALUE</th>
							<th>CONTACT_DETAILS</th>
							<th>STATUS</th>
							<th>ACTIVE</th>
							<th>EDIT</th>
						</tr>
					</tfoot>

				</table>
			</div>
		</div>

		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h6 class="modal-title font-weight-border">Add New Category</h6>
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<sf:form id="validateCategoryForm" modelAttribute="category"
							action="${contextRoot}/manage/category" method="POST"
							class="form-horizontal">

							<div class="form-group">
								<label for="name" class="control-label col-lg-4">Enter
									Category Name:</label>
								<div class="col-lg-8">
									<sf:input type="text" path="name"
										placeholder="enter category name here" />
									<sf:errors name="name" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label for="description" class="control-label col-lg-4">Enter
									category description:</label>
								<div class="col-lg-8">
									<sf:textarea type="text" path="description" id="description"
										placeholder="enter description for category here" />
									<sf:errors name="description" cssClass="help-block"
										element="em" />
								</div>
							</div>

							<div class="form-group">

								<div class="col-lg-8 offste-lg-4">
									<input type="submit" value="Add Category"
										class="btn btn-primary" />
								</div>
							</div>

						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>