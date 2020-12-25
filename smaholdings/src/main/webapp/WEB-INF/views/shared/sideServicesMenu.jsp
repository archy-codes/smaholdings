<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<c:forEach items="${categories}" var="category">
		  <ol class="list-unstyled mb-0 py-1">
			<li><a href="${contextRoot}/category/${servicesMenu.id}/services">${category.name}</a>
			</li>
		  </ol>
		</c:forEach>
