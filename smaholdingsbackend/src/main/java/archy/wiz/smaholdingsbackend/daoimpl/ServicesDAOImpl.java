package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import archy.wiz.smaholdingsbackend.dao.ServicesDAO;
import archy.wiz.smaholdingsbackend.dto.Services;


@Repository("servicesDAO")
@Transactional
public class ServicesDAOImpl implements ServicesDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Services get(int id) {
		return sessionFactory.getCurrentSession().get(Services.class, Integer.valueOf(id));
	}

	@Override
	public List<Services> getActiveServices() {
		return sessionFactory
				  .getCurrentSession()
				       .createQuery("FROM Services WHERE active = :active", Services.class)
				           .setParameter("active", true)
				                .getResultList();
	}

	@Override
	public boolean add(Services services) {
		try {
			sessionFactory
			    .getCurrentSession()
			       .persist(services);
			             return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Services services) {
		try {
			sessionFactory
			   .getCurrentSession()
			      .update(services);
			          return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Services services) {
		services.setActive(false);
		try {
			sessionFactory
			   .getCurrentSession()
			       .update(services);
			          return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
