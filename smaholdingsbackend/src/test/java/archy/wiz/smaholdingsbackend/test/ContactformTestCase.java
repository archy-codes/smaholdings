package archy.wiz.smaholdingsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import archy.wiz.smaholdingsbackend.dao.ContactformDAO;
import archy.wiz.smaholdingsbackend.dto.Contactform;

public class ContactformTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ContactformDAO contactformDAO;
	private Contactform contactform;
	
	
	@BeforeClass
	public static void init() {
	  context = new AnnotationConfigApplicationContext();
	  context.scan("archy.wiz.smaholdingsbackend");
	  context.refresh();
	  contactformDAO = (ContactformDAO)context.getBean("contactformDAO");
	}
	
	@Test
	public void CrudeContactTest() {
		
		
		/* adding a contactform */
		contactform = new Contactform();
		contactform.setFname("mbulungeni");
		contactform.setLname("mulaudzi");
		contactform.setEmail("mbuluarchy1@gmail.com");
		contactform.setDescription("we just want to ask how you work on the road");
		contactform.setCategoryId(1);
		assertEquals("successfully submitted a query",true , contactformDAO.add(contactform));
		
		contactform = new Contactform();
		contactform.setFname("archybald");
		contactform.setLname("mulaudzi");
		contactform.setEmail("mbuluarchy1@gmail.com");
		contactform.setDescription("get us info about the bridges");
		contactform.setCategoryId(2);
		assertEquals("successfully submitted a query",true , contactformDAO.add(contactform));
		
		contactform = new Contactform();
		contactform.setFname("pfano");
		contactform.setLname("mulaudzi");
		contactform.setEmail("mbuluarchy1@gmail.com");
		contactform.setDescription("we just want to ask about the training");
		contactform.setCategoryId(3);
		assertEquals("successfully submitted a query",true , contactformDAO.add(contactform));
		

		/*getting the contactform  and updating it */
		contactform = contactformDAO.get(3);
		contactform.setFname("aluwani");
		contactform.setLname("mulaudzi");
		contactform.setEmail("aluwani@gmail.com");
		contactform.setDescription("we just want to ask about the training");
		contactform.setCategoryId(3);
		assertEquals("successfully updated a query",true , contactformDAO.update(contactform));
		
		/*fetching and deleting the contactform */
		assertEquals("successfully deleted a query",true , contactformDAO.delete(contactform));
		
		/*successfully fetched a list of queries*/
		assertEquals("successfully fetched a list of queries",3 , contactformDAO.list().size());
		
		/*fetching list of active contactform */
		assertEquals("successfully fetched a list of active queries",2 , contactformDAO.activeContactform().size());
        

		/*fetching the contactform based on the category*/
		assertEquals("successfully fetched a list of queries",1, contactformDAO.activeContactformBycategory(1).size());

		assertEquals("successfully fetched a list of queries",1, contactformDAO.activeContactformBycategory(2).size());

	}

}
