package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Register;
import com.niit.shoppingcart.model.Register;
@SuppressWarnings("unused")
@Repository("registerDAO")
public class RegisterDAOImpl implements RegisterDAO {
	@Autowired
	private SessionFactory sessionFactory;


	public RegisterDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(Register Register) {
		sessionFactory.getCurrentSession().saveOrUpdate(Register);
			
	}

	@Transactional
	public void delete(String Uname) {
		Register Register = new Register();
		Register.setUname(Uname);
		sessionFactory.getCurrentSession().delete(Register);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Register get(String Uname) {
		String hql = "from Register where Uname=" + "'"+ Uname +"'";
		//  from Register where Uname = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Register> listRegister = (List<Register>) query.list();
		
		if (listRegister != null && !listRegister.isEmpty()) {
			return listRegister.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Register> list() {
		@SuppressWarnings("unchecked")
		List<Register> listRegister = (List<Register>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Register.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listRegister;
	}
	
	


}
