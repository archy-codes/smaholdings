
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <ul class="nav nav-pills" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="pill" href="#manageProject">Project Management</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#manageBlog">Blog Management</a>
    </li>
  </ul>

<div class="tab-content mb-5">
    <div id="manageProject" class="container tab-pane active"><br>
      <div class="card mt-3">
        <div class="card-header text-center">
            <h5 class="font-weight-bold">manage project</h5>
        </div>
        <div class="card-body">
           <!-- form elements -->
           <sf:form class="form-horizontal" modelAttribute="project" action="${contextRoot}/manage/projects" method="POST">
           
            <div class="form-group">
              <div class="row">
                <label class="control-label col-lg-4 col-xl-4" for="projectName">Enter project name:</label>
                <div class="col-lg-8 col-xl-8">
                  <sf:input type="text" path="projectName" id="projectName" placeholder="project name here:" class="form-control" />
                </div>
                </div>
              </div>
              
            <div class="form-group">
              <div class="row">
                <label class="control-label col-lg-4 col-xl-4" for="client">Enter client name:</label>
                <div class="col-lg-8 colxl-8">
                  <sf:input type="text" path="client" id="client" placeholder="client name here:" class="form-control" />
                </div>
                </div>
            </div>

            <div class="form-group">
              <div class="row">
                <label class="control-label col-lg-4 colxl-4" for="contactDetails">Enter client contact:</label>
                <div class="col-lg-8 col-xl-8">
                  <sf:input type="text" path="contactDetails" id="contactDetails" placeholder="name and contact" class="form-control" />
                </div>
                </div>
            </div>
             
            <div class="form-group">
              <div class="row">
                <label class="control-label col-lg-4" for="value">Enter project Value:</label>
                <div class="col-lg-8 col-xl-8">
                  <sf:input type="number" path="value" id="value" placeholder="R100000" class="form-control" />
                </div>
                </div>
            </div>

            <div class="form-group">
              <div class="row">
                <label class="control-label col-lg-4 col-xl-4" for="status">Enter project Status:</label>
                <div class="col-lg-8 col-xl-8">
                  <sf:input type="text" path="status" id="status" placeholder="project status" class="form-control" />
                </div>
                </div>
            </div>
            
                
             <div class="form-group">
              <div class="row">
                <label class="control-label col-lg-4 col-xl-4" for="value">Enter project description:</label>
                <div class="col-lg-8 col-xl-8">
                 <sf:textarea name="description" path="description" rows="5" cols="10" placeholder="project description here" class="form-control" />
                </div>
                </div>
            </div>

             <div class="form-group">
              <div class="row">
                <label class="control-label col-lg-4 col-xl-4" for="categoryId">Select Category:</label>
                <div class="col-lg-8 col-xl-8">
                   <sf:select class="form-control" id="categoryId" path="categoryId"
                       items="${categories}"
                       itemLabel="name"
                       itemValue="id"
                   />
                </div>
                </div>
            </div>
            

             <div class="form-group">
              <div class="row">
                <div class="col-lg-12 col-xl-4 offset-xl-4">
                 <input type="submit" id="submit" value="submit" class="btn btn-success" />
                 
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
    
    <div id="#manageBlog" class="container tab-pane fade"><br>
      <div class="card mt-5">
        <div class="card-header text-center">
            <h5 class="font-weight-bold">manage the blog</h5>
        </div>
        <div class="card-body">
          <!-- form  elements -->
          
        </div>
      </div>
     
    </div>
  </div>
  
           
      </div>  
   </div>
</div>