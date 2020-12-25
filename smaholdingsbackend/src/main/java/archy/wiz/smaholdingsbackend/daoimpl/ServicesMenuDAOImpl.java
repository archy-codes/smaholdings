package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import archy.wiz.smaholdingsbackend.dao.ServicesMenuDAO;
import archy.wiz.smaholdingsbackend.dto.ServicesMenu;



@Repository("servicesMenuDAO")
@Transactional
public class ServicesMenuDAOImpl implements ServicesMenuDAO {
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ServicesMenu> getActiveServiceList() {
		return sessionFactory
				   .getCurrentSession()
				       .createQuery("FROM ServicesMenu WHERE active = :active" , ServicesMenu.class)
				           .setParameter("active", true)
				               .getResultList();
	}

	@Override
	public boolean add(ServicesMenu servicesmenu) {
		try {
			sessionFactory
			  .getCurrentSession()
			      .persist(servicesmenu);
			         return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public ServicesMenu get(int id) {
		return sessionFactory.getCurrentSession().get(ServicesMenu.class, Integer.valueOf(id));
	}

}
