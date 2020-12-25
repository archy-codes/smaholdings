package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import archy.wiz.smaholdingsbackend.dao.ContactformDAO;
import archy.wiz.smaholdingsbackend.dto.Contactform;


@Repository("contactformDAO")
@Transactional
public class ContactformDAOImpl implements ContactformDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Contactform get(int id) {
		return sessionFactory.getCurrentSession().get(Contactform.class, Integer.valueOf(id));
	}

	@Override
	public List<Contactform> list(){
		return sessionFactory
		     .getCurrentSession()
		         .createQuery("FROM Contactform", Contactform.class)
		              .getResultList();
		   
	}

	@Override
	public List<Contactform> activeContactform() {
		return sessionFactory
				   .getCurrentSession()
				       .createQuery("FROM Contactform Where active = :active", Contactform.class)
				          .setParameter("active", true)
				             .getResultList();
	}

	@Override
	public boolean add(Contactform contactform) {
		try {
			sessionFactory.getCurrentSession().persist(contactform);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Contactform contactform) {
		try {
			sessionFactory.getCurrentSession().update(contactform);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Contactform contactform) {
		contactform.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(contactform);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Contactform> activeContactformBycategory(int categoryId) {
	  return sessionFactory
			     .getCurrentSession()
			        .createQuery("FROM Contactform WHERE active = :active AND categoryId = :categoryId", Contactform.class)
			           .setParameter("active", true)
			              .setParameter("categoryId", categoryId)
			                  .getResultList();
	}

}
