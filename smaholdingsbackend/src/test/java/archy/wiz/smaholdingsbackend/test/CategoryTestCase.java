package archy.wiz.smaholdingsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import archy.wiz.smaholdingsbackend.dao.CategoryDAO;
import archy.wiz.smaholdingsbackend.dto.Category;

public class CategoryTestCase {
	
 private static AnnotationConfigApplicationContext context;
 private static CategoryDAO categoryDAO;
 private Category category;
 
 
 @BeforeClass
 public static void init() {
	 context = new AnnotationConfigApplicationContext();
	 context.scan("archy.wiz.smaholdingsbackend");
	 context.refresh();
	 categoryDAO = (CategoryDAO)context.getBean("categoryDAO"); 
 }
 

 
 @Test 
 public void testCRUDcategory() {
	 
	 //adding a single category
	    category =  new Category();
	    category.setName("ENGENEERING");
		category.setDescription("all engeneering work work");
		category.setImageUrl("CAT_1.png");
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
	    
		category =  new Category();
	    category.setName("LOGISTICS");
		category.setDescription("	all logistics work");
		category.setImageUrl("CAT_2.png");
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
	
	    category =  new Category();
	    category.setName("PROJECT PLANNING AND MANAGEMENT");
		category.setDescription("all project management work");
		category.setImageUrl("CAT_3.png");
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
	
	    category =  new Category();
	    category.setName("ACCRIDITED TRAINING");
		category.setDescription("all the training work	");
		category.setImageUrl("CAT_4.png");
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
	
	    category =  new Category();
	    category.setName("CATERING");
		category.setDescription("all the catering work");
		category.setImageUrl("CAT_5.png");
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
	
	    category =  new Category();
	    category.setName("CLEANING");
		category.setDescription("all the cleaning work");
		category.setImageUrl("CAT_6.png");
		assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
		
		 category =  new Category();
		 category.setName("SOCIAL INVESTMENT.");
	     category.setDescription("all the social work");
	     category.setImageUrl("CAT_7.png");
	     assertEquals("Successfully added category inside the table",true,categoryDAO.add(category));
		
		
		//fetching and updating a category
		 category = categoryDAO.get(7);
		 category.setName("SOCIAL INVESTMENT");
		 assertEquals("Successfully a fatched  and updated a single category from the table",true,categoryDAO.update(category));
 
		 
		 //deleting the category
		 assertEquals("Successfully a deleted a single category from the table",true,categoryDAO.delete(category));
		 
		 //fetching the list of active categories 
		 assertEquals("Successfully fecthed the list from Table",7,categoryDAO.list().size()); 
		 
         
		 
		 
		 
 
 }
 
 
}
