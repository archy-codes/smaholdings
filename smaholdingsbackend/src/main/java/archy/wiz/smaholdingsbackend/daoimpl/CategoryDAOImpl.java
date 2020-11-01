package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import archy.wiz.smaholdingsbackend.dao.CategoryDAO;
import archy.wiz.smaholdingsbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> list() {
		   return sessionFactory
				    .getCurrentSession()
				       .createQuery("FROM Category",Category.class)
				               .getResultList();
	}
	
	
	@Override
	public Category get(int id){
		try {
		return sessionFactory
				.getCurrentSession()
				      .get(Category.class, Integer.valueOf(id));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean add(Category category) {
		try {
			//adding a service in the database
			 sessionFactory
					.getCurrentSession()
					   .persist(category);
		                      return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory
			  .getCurrentSession()
			        .update(category);
		                  return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;	
		}
	}
	
	
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory
			  .getCurrentSession()
			        .update(category);
		                 return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	

}
