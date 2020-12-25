package archy.wiz.smaholdingsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import archy.wiz.smaholdingsbackend.dao.ServicesMenuDAO;
import archy.wiz.smaholdingsbackend.dto.ServicesMenu;

public class ServicesMenuCrudeTest {
	
	private static AnnotationConfigApplicationContext context;
	private static ServicesMenuDAO servicesMenuDAO;
	private ServicesMenu servicesMenu;
	
	@BeforeClass
	public static void addTest() {
		context = new AnnotationConfigApplicationContext();
		context.scan("archy.wiz.smaholdingsbackend");
		context.refresh();
		servicesMenuDAO = (ServicesMenuDAO)context.getBean("servicesMenuDAO");
	}
	
	@Test
	public void init() {
		servicesMenu = new ServicesMenu();
		servicesMenu.setName("engeneering");
		servicesMenu.setImageUrl("servicesmenu.jpg");
		assertEquals("you have successfully added a service", true , servicesMenuDAO.add(servicesMenu));
		
		servicesMenu = new ServicesMenu();
		servicesMenu.setName("Training");
		servicesMenu.setImageUrl("servicesmenu2.jpg");
		assertEquals("you have successfully added a service", true , servicesMenuDAO.add(servicesMenu));
		
		servicesMenu = new ServicesMenu();
		servicesMenu.setName("WEEYZ");
		servicesMenu.setImageUrl("servicesmenu3.jpg");
		assertEquals("you have successfully added a service", true , servicesMenuDAO.add(servicesMenu));
		
		servicesMenu = new ServicesMenu();
		servicesMenu.setName("MBulu");
		servicesMenu.setImageUrl("servicesmenu4.jpg");
		assertEquals("you have successfully added a service", true , servicesMenuDAO.add(servicesMenu));
	}
	

}
