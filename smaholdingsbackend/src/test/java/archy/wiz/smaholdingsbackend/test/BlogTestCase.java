package archy.wiz.smaholdingsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import archy.wiz.smaholdingsbackend.dao.BlogCategoryDAO;
import archy.wiz.smaholdingsbackend.dto.BlogCategory;

public class BlogTestCase {

	private static AnnotationConfigApplicationContext context;
	private static BlogCategoryDAO blogCategoryDAO;
	private BlogCategory blogCategory;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("archy.wiz.smaholdingsbackend");
		context.refresh();
		blogCategoryDAO = (BlogCategoryDAO) context.getBean("BlogCategory");
	}

	@Test
	public void crudeTest() {

		blogCategory = new BlogCategory();
		blogCategory.setName("engeneering");
		blogCategory.setImageUrl("archy1.jpg");
		blogCategory.setDescription("this is the description for the blog category engeneering");
		assertEquals("you have successfully added a blog category", true, blogCategoryDAO.add(blogCategory));

		blogCategory = new BlogCategory();
		blogCategory.setName("cleaning");
		blogCategory.setImageUrl("archy2.jpg");
		blogCategory.setDescription("this is the description for the blog category cleaning");
		assertEquals("you have successfully added a blog category", true, blogCategoryDAO.add(blogCategory));

		blogCategory = new BlogCategory();
		blogCategory.setName("catering");
		blogCategory.setImageUrl("archy3.jpg");
		blogCategory.setDescription("this is the description for the blog category catering");
		assertEquals("you have successfully added a blog category", true, blogCategoryDAO.add(blogCategory));

		blogCategory = new BlogCategory();
		blogCategory.setName("project plannig and management");
		blogCategory.setImageUrl("archy4.jpg");
		blogCategory.setDescription("this is the description for the blog category project planning");
		assertEquals("you have successfully added a blog category", true, blogCategoryDAO.add(blogCategory));

		blogCategory = new BlogCategory();
		blogCategory.setName("logistics");
		blogCategory.setImageUrl("archy5.jpg");
		blogCategory.setDescription("this is the description for the blog category logistics");
		assertEquals("you have successfully added a blog category", true, blogCategoryDAO.add(blogCategory));

		blogCategory = new BlogCategory();
		blogCategory.setName("social2");
		blogCategory.setImageUrl("archy6.jpg");
		blogCategory.setDescription("this is the description for the blog category social2");
		assertEquals("you have successfully added a blog category", true, blogCategoryDAO.add(blogCategory));

		
		//fetching and updating a category
		blogCategory = blogCategoryDAO.get(6);
		blogCategory.setName("social");
		blogCategory.setDescription("this is the description for the blog category social");
		assertEquals("you have successfully updated  a blog category two", true, blogCategoryDAO.update(blogCategory));

		//deleting a blog category
		assertEquals("successfully deleted a blog category", true, blogCategoryDAO.delete(blogCategory));

		//fetchign a list of blog categories
		assertEquals("successfully fetched a list of blog category", 6, blogCategoryDAO.list().size());

	}
}
