<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="list-group">
<c:forEach items="${categories}" var="category">
   <a href="${contextRoot}/show/category/${category.id}/services" class="list-group-item"><strong>${category.name}</strong></a>
</c:forEach>
</div>