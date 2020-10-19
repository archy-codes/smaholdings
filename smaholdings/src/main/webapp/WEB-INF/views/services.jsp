<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid py-5">
  <div class="row">
  <div class="col-lg-12">
  <h5 class="text-danger"><strong>WHAT WE DO.</strong></h5>
  </div>
      <div class="col-lg-3">
        <%@include file="./shared/sidebar.jsp" %>
      </div>
      <div class="col-lg-8">
         <div class="row">
            <div class="col-lg-12">
            
            <c:if test="${userClicksServices == true}">
               <ol class="breadcrumb">
                 <li><a href="${contextRoot}/home">Home</a></li>
                 <li class="active">All services</li>
               </ol>
             </c:if>
             
             <c:if test="${userClicksCategoryServices == true}">
               <ol class="breadcrumb">
                 <li><a href="${contextRoot}/home">Home</a></li>
                 <li>Services</li>
                 <li>${category.name}</li>
               </ol>
               </c:if>
            </div>
         </div>
         
          <!-- here comes our services info -->
         <div class="row">
           <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
           <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
            
           <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
                       <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
           <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
            
           <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
            
            <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
           <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
            
           <div class="col-lg-4 mb-4">
             <div class="card h-100">
                <h4 class="card-header">Card Title</h4>
                <div class="card-body">
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                  <a href="#" class="btn btn-primary">Learn More</a>
                </div>
              </div>
            </div>
         </div>
      </div>
  </div>
</div>

<div class="container-fluid">
  <div class="row text-white" style="margin-top:3%; padding-top:10px; background-color:rgb(0,0,0,0.6);">
          <div class="col-lg-3 single-fact text-center">
               <h4><strong>PROJECTS</strong></h4>
               <i class="fas fa-building" style="width:60px; height:45px;"></i>
               <h1 class="count">R150</h1>
            </div>
            <div class="col-lg-3 single-fact text-center">
               <h4><strong>REVANUES</strong></h4>
               <i class="fas fa-coins" style="width:60px; height:45px;"></i>
               <h1 class="count">R8,216000</h1>
            </div>
            <div class="col-lg-3 single-fact text-center">
               <h4><strong>HAPPY CLIENTS</strong></h4>
               <i class="fas fa-users" style="width:60px; height:45px;"></i>
               <h1 class="count">200</h1>
            </div>
            <div class="col-lg-3 single-fact text-center">
               <h2>Revanues</h2>
               <h1 class="count">963</h1>
            </div>
            
  </div>
</div>








