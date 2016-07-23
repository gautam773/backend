package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Login;



public interface LoginDAO {
	
	public List<Login> list();

	public Login get(String uname);
	
	public void saveOrUpdate(Login login);

	public void delete(String uname);
}
