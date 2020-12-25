package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import archy.wiz.smaholdingsbackend.dao.BlogCategoryDAO;
import archy.wiz.smaholdingsbackend.dto.BlogCategory;

@Repository("BlogCategory")
@Transactional
public class BlogCategoryDAOImpl implements BlogCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<BlogCategory> list() {
		return sessionFactory
				  .getCurrentSession()
				     .createQuery("From BlogCategory",BlogCategory.class)
				        .getResultList();
	}

	@Override
	public BlogCategory get(int id) {
		return sessionFactory.getCurrentSession().get(BlogCategory.class,Integer.valueOf(id));
	}

	@Override
	public boolean add(BlogCategory blogCategory) {
		try {
			sessionFactory
			   .getCurrentSession()
			      .persist(blogCategory);
			         return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(BlogCategory blogCategory) {
		try {
			sessionFactory
			   .getCurrentSession()
			      .update(blogCategory);
			        return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(BlogCategory blogCategory) {
		blogCategory.setActive(false);
		try {
			sessionFactory
			   .getCurrentSession()
			      .update(blogCategory);
			        return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
