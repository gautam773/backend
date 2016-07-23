package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Login;

@Repository("loginDAO")
public class LoginDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;


	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(Login login) {
		sessionFactory.getCurrentSession().saveOrUpdate(login);
			
	}

	@Transactional
	public void delete(String uname) {
		Login login = new Login();
		login.setUname(uname);
		sessionFactory.getCurrentSession().delete(login);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Login get(String uname) {
		String hql = "from Login where uname=" + "'"+ uname +"'";
		//  from category where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Login> listLogin = (List<Login>) query.list();
		
		if (listLogin != null && !listLogin.isEmpty()) {
			return listLogin.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Login> list() {
		@SuppressWarnings("unchecked")
		List<Login> listLogin = (List<Login>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Login.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listLogin;
	}
	
	
}
