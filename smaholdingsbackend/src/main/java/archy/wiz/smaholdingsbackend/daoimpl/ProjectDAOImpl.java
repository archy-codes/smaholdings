package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import archy.wiz.smaholdingsbackend.dao.ProjectDAO;
import archy.wiz.smaholdingsbackend.dto.Project;


@Repository("projectDAO")
@Transactional
public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Project get(int id) {
		try {
			return sessionFactory
					.getCurrentSession()
					     .get(Project.class, Integer.valueOf(id));
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Project> list() {
	return sessionFactory
				.getCurrentSession()
				        .createQuery("From Project", Project.class)
		                        .getResultList(); 
	}

	@Override
	public boolean add(Project project) {
		try {
			sessionFactory
			  .getCurrentSession()
			     .persist(project);
			         return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Project project) {
		try {
			sessionFactory
			   .getCurrentSession()
			       .update(project);
			          return true;
		}catch(Exception ex) {
			ex.printStackTrace(); 
			return false;
		}
	}

	@Override
	public boolean delete(Project project) {
		project.setActive(false);
		try {
			sessionFactory
			  .getCurrentSession()
			      .update(project);
			         return true;
		}catch(Exception ex) {
			    ex.printStackTrace();
			    return false;
		}
	}

	@Override
	public List<Project> listActiveProjects() {
		return sessionFactory
				   .getCurrentSession()
				          .createQuery("FROM Project WHERE active = :active",Project.class)
				                   .setParameter("active", true)
				                        .getResultList();
	}

	@Override
	public List<Project> listActiveProjectsByCategory(int categoryId) {
		return sessionFactory
				   .getCurrentSession()
				          .createQuery("FROM Project WHERE active = :active AND categoryId = :categoryId",Project.class)
				                   .setParameter("active", true)
				                       .setParameter("categoryId", categoryId)
				                          .getResultList();
	}

	@Override
	public List<Project> listLatestActiveProjects(int count) {
		return sessionFactory
				   .getCurrentSession()
				          .createQuery("FROM Project WHERE active = :active ORDER BY id",Project.class)
				                   .setParameter("active", true)
				                     .setFirstResult(0)
				                        .setMaxResults(count)
				                           .getResultList();
	}

	

}
