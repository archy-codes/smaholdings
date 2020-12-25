package archy.wiz.smaholdingsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import archy.wiz.smaholdingsbackend.dao.UserDAO;
import archy.wiz.smaholdingsbackend.dto.User;

public class UserTestCase {
    private static AnnotationConfigApplicationContext context;
    private static UserDAO userDAO;
    private User user;
    
    @BeforeClass
    public static void init() {
    	context = new AnnotationConfigApplicationContext();
    	context.scan("archy.wiz.smaholdingsbackend");
    	context.refresh();
    	userDAO = (UserDAO)context.getBean("userDAO");
    	
    }
    
    @Test
    public void CrudeForUserTestCase(){
    	
    	user = new User();
    	user.setFirstname("mbulungeni");
    	user.setLastname("mulaudzi");
    	user.setEmail("mbuluarchy1@gmail.com");
    	user.setContactnumber("0767289561");
    	user.setRole("ADMIN");
    	user.setPassword("12345");
    	assertEquals("you have successfully logged in",true,userDAO.add(user));
    	
    	user = new User();
    	user.setFirstname("aluwani");
    	user.setLastname("mulaudzi");
    	user.setEmail("aluwaniclevens@gmail.com");
    	user.setContactnumber("0788149528");
    	user.setRole("ADMIN");
    	user.setPassword("12345");
    	assertEquals("you have successfully logged in",true,userDAO.add(user));
    	

    }
}
