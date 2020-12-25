package archy.wiz.smaholdingsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import archy.wiz.smaholdingsbackend.dao.BlogDAO;
import archy.wiz.smaholdingsbackend.dto.Blog;

public class BlogerTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static BlogDAO blogDAO;
	private Blog blog;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("archy.wiz.smaholdingsbackend");
		context.refresh();
		blogDAO = (BlogDAO)context.getBean("blogDAO");
	}
	
	@Test
	public void blogerCrude() {
		
		blog = new Blog();
		blog.setName("project hading out at polokwane");
		blog.setDescription("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley");
		blog.setBlogdate("2020-05-03");
		blog.setAdminId(1);
		blog.setBlogCategoryId(1);
		assertEquals("failed to add a blog", true , blogDAO.add(blog));
		
		blog = new Blog();
		blog.setName("Why do we use it?");
		blog.setDescription("It is a long established fact that a reader will be distracte");
		blog.setBlogdate("2020-08-08");
		blog.setAdminId(1);
		blog.setBlogCategoryId(1);
		assertEquals("failed to add a blog", true , blogDAO.add(blog));
		
		blog = new Blog();
		blog.setName("Where can I get some");
		blog.setDescription("Lorem Ipsum dummy text ever since the 1500s, when an unknown printer took a galley");
		blog.setBlogdate("2020-03-03");
		blog.setAdminId(2);
		blog.setBlogCategoryId(2);
		assertEquals("failed to add a blog", true , blogDAO.add(blog));
		
		blog = new Blog();
		blog.setName("project hading out at mokopane");
		blog.setDescription(" standard dummy text ever since the 1500s, when an unknown printer took a galley");
		blog.setBlogdate("2020-05-03");
		blog.setAdminId(2);
		blog.setBlogCategoryId(1);
		assertEquals("failed to add a blog", true , blogDAO.add(blog));
		
		blog = new Blog();
		blog.setName("project hading out at polokwane");
		blog.setDescription("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley");
		blog.setBlogdate("2020-01-03");
		blog.setAdminId(1);
		blog.setBlogCategoryId(2);
		assertEquals("failed to add a blog", true , blogDAO.add(blog));
		
		//fetching a blog category and deleting
		
		blog = blogDAO.get(5);
		blog.setName("project hading out at muwaweni");
		blog.setDescription("Lorem text ever since the 1500s, when an unknown printer took a galley");
		blog.setBlogdate("2020-01-01");
		blog.setAdminId(2);
		blog.setBlogCategoryId(1);
		assertEquals("failed to update a blog", true , blogDAO.update(blog));
		
		
		//fetchign and deleting a blog
		blog = blogDAO.get(5);
		assertEquals("failed to delete a blog", true , blogDAO.delete(blog));
		
		//fetching list of blogs
		assertEquals("failed to fetch a blog list", 5 , blogDAO.list().size());

		//fetching list of active blogs
		assertEquals("failed to fetch a list of active blogs blog list", 4 , blogDAO.listActiveBlogs().size());

		//fetching list of active blogs by category
		assertEquals("failed to fetch a list of active blogs blog list", 3 , blogDAO.listActiveByBlogCategory(1).size());
		assertEquals("failed to fetch a list of active blogs blog list", 1 , blogDAO.listActiveByBlogCategory(2).size());

		//fetching list of active latest blogs
		assertEquals("failed to fetch a list of active list by order", 4 , blogDAO.listLatestActiveBlogs(4).size());

		
	}
}
