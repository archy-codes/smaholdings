<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
  <div class="row">
     <div class="col-lg-12 colxl-12" id="project-top-section-image">
         <div class="col-lg-12 col-xl-12  text-secondary" id="services-section">
            <h3 class="text-primary mb-5"><strong>Quality Has Always Been Our Priority<br /> <small>When Coming to Project Delivery</small></strong></h3>
            
             <p class="text-secondary mb-5">We provide all kinds of construction services
               ,building services , Logistics , Catering and Events Managements Services 
                .Quality is always our priority at all times.
             </p>              
        </div>
        <div class="col-lg-4 offset-lg-6 col-xl-4" >
          <a class="btn btn-md btn-primary btn-block mr-5" id="services-button" href="${contextRoot}/contact"><strong>Request Quote</strong></a>
        </div>
     </div>
  </div>
</div> 
<div class="container">
  <div class="row">
  <div class="col-lg-12 col-xl-12">
  <h5 class="text-secondary"><strong> Check Out Our Projects</strong></h5>
  </div>
      <div class="col-lg-3 col-xl-3">
        <%@include file="./shared/sidebar.jsp" %>
      </div>
      <div class="col-lg-9 col-xl-9">
         <div class="row">
            <div class="col-lg-12 col-xl-12">
            
            <c:if test="${userClicksProjects == true }">
               
               <script>
                     window.categoryId = '';
               </script>
               
               <ol class="breadcrumb">
                 <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                 <li  class="breadcrumb-item active">All Projects</li>
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
                 <div class="col-lg-12 col-xl-12">
                    <table id="projectListTable" class="table table-striped table-bordered" >
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
               </div>
    </div>
  </div>
</div>







