package com.niit.shoppingcart.dao;

import java.util.List;


import com.niit.shoppingcart.model.Register;


public interface RegisterDAO {
	public List<Register> list();

	public Register get(String uname);
	
	public void saveOrUpdate(Register register);

	public void delete(String uname);

}
