package com.niit.shoppingcart.model;

import javax.persistence.Id;

public class Login {
private String uname;
private String password;
@Id
public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
