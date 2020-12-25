<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container mt-5 mb-5" >
  <div class="row">
  <c:forEach items="${servicesinfo}" var="infoservices">
      <div class="col-lg-4 mb-3 border border-muted">
           <a href="${contextRoot}/more/services/more"><img alt="" src="${images}/catering.jpg" style="height:240px; background-image:cover; background-repeat:none;"></a>
           <h6 class="font-weight-bold mt-2"><a href="${contextRoot}/more/services/more">${infoservices.name}</a></h6>
      </div>
  </c:forEach>
  </div>
  </div>