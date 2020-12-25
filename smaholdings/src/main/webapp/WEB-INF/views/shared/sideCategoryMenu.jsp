<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<c:forEach items="${blogcategories}" var="category">
		  <ol class="list-unstyled mb-0 py-1">
			<li><a class="movecategories" href="${contextRoot}/show/blogcategory/${category.id}/blogs">${category.name}<br /></a></li>
		  </ol>
		</c:forEach>
