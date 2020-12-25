package archy.wiz.smaholdingsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import archy.wiz.smaholdingsbackend.dao.ServicesDAO;
import archy.wiz.smaholdingsbackend.dto.Services;

public class ServicesTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ServicesDAO servicesDAO;
	private Services services;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("archy.wiz.smaholdingsbackend");
		context.refresh();
		servicesDAO = (ServicesDAO)context.getBean("servicesDAO");
	}
	
	
	@Test
	public void CrudeServiceTest(){
		
		services = new Services();
		services.setName("civil engeneering");
		services.setDescription("the nest team at work");
		services.setIcon("services1.jpg");
		assertEquals("you have successfully added a service",true, servicesDAO.add(services));

		services = new Services();
		services.setName("Green energy");
		services.setDescription("engeneering at its best");
		services.setIcon("services2.jpg");
		assertEquals("you have successfully added a service", true, servicesDAO.add(services));

		services = new Services();
		services.setName("engeneering");
		services.setDescription("working towards future");
		services.setIcon("services3.jpg");
		assertEquals("you have successfully added a service", true, servicesDAO.add(services));

		services = new Services();
		services.setName("Engeneering");
		services.setDescription("the nest team at work");
		services.setIcon("services4.jpg");
		assertEquals("you have successfully added a service", true, servicesDAO.add(services));

		services = new Services();
		services.setName("Engeneering");
		services.setDescription("the nest team at work");
		services.setIcon("services5.jpg");
		assertEquals("you have successfully added a service",true, servicesDAO.add(services));
		
		services = new Services();
		services.setName("Engeneering");
		services.setDescription("the nest team at work");
		services.setIcon("services6.jpg");
		assertEquals("you have successfully added a service", true, servicesDAO.add(services));
		
		assertEquals("you have successfully fetched list of active services",6,servicesDAO.getActiveServices().size());
				
		
	}
}
