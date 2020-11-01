<div class="container">
  <div class="row">
    <div class="col-lg-12">
        <ol class="breadcrumb">
          <li><a href="${contextRoot}/home">Home</a></li>
          <li><a href="${contextRoot}/show/all/projects">Projects</a></li>
          <li class="active">${project.projectName}</li>
        </ol>
    </div>
  </div>
  
  <div class="row">
   <!-- diplaying of project images slider -->
     <div class="col-lg-6">
       <div class="thumbnail">
          <img id="singlePageProjectImage" src="${images}/${project.code}.jpg" class="img img-responsive"/>    
       </div>
     </div>
     
     <!-- displaying the project information -->
     <div class="col-lg-6">
         <h6>${project.projectName}</h6>
         <hr/>
         <h6>${project.client}</h6>
         <hr/>
         <h6>${project.description}</h6>
         <hr/>
         <h6>${project.value}</h6>
         <hr/>
         <h6>${project.contactDetails}</h6>
         <hr/>
         <h6>${project.status}</h6>
         <hr/>
         
         <a href="${contextRoot}/show/all/projects" class="btn btn-success">BACK</a>
         
     </div>
  </div>
</div>