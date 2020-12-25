package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import archy.wiz.smaholdingsbackend.dao.BlogDAO;
import archy.wiz.smaholdingsbackend.dto.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Blog get(int id) {
		return sessionFactory.getCurrentSession().get(Blog.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Blog blog) {
		try {
			sessionFactory.getCurrentSession().persist(blog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Blog blog) {
		blog.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Blog> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Blog", Blog.class).getResultList();
	}

	@Override
	public List<Blog> listActiveBlogs() {
		return sessionFactory.getCurrentSession().createQuery("FROM Blog WHERE active = :active", Blog.class)
				.setParameter("active", true).getResultList();

	}

	@Override
	public List<Blog> listActiveByBlogCategory(int blogCategoryId) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Blog Where active = :active AND blogCategoryId = :blogCategoryId", Blog.class)
				.setParameter("active", true).setParameter("blogCategoryId", blogCategoryId).getResultList();
	}

	@Override
	public List<Blog> listLatestActiveBlogs(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Blog WHERE active = :active ORDER By id", Blog.class).setParameter("active", true)
				.setFirstResult(0).setMaxResults(count).getResultList();
	}

	@Override
	public List<Blog> getBlogsByParam(String param, int count) {
		
		return sessionFactory
				.getCurrentSession()
				   .createQuery("FROM Blog WHERE active = true ORDER BY " + param + " DESC", Blog.class)
				      .setFirstResult(0)
				          .setMaxResults(count)
				                .getResultList();
	}

}
