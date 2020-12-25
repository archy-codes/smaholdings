<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/projects"
			class="list-group-item" id="a_${category.name}"><strong>${category.name}</strong></a>
	</c:forEach>
</div>