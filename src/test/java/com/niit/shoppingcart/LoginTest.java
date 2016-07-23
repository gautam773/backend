package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.LoginDAO;
import com.niit.shoppingcart.model.Login;




public class LoginTest {
	public static void main(String[] args) {
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	context.scan("com.niit.shoppingcart");
	context.refresh();
	
	
   LoginDAO loginDAO = 	(LoginDAO) context.getBean("loginDAO");
   
   Login login = 	(Login) context.getBean("login");
   login.setUname("venkat773");
  login.setPassword("Genius");
   
  loginDAO.saveOrUpdate(login);	   
 System.out.println("Successfully Registered");
	
	
}

}
