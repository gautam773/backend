package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.RegisterDAO;
import com.niit.shoppingcart.model.Register;

public class RegisterTest {
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   RegisterDAO registerDAO = 	(RegisterDAO) context.getBean("registerDAO");
	   
	   Register register = 	(Register) context.getBean("register");
	   register.setUname("venkat773");
	   register.setPassword("Genius");
	   register.setRepwd("Genius");
	   register.setDob("06.02.1992");
	   register.setSex("male");
	   register.setPhnum("9585779265");
	   register.setCity("Coimbatore");
	   register.setPincode("641669");
	   
	   registerDAO.saveOrUpdate(register);	   
	 System.out.println("Successfully Registered");
		
		
	}

}

