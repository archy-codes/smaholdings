package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import archy.wiz.smaholdingsbackend.dao.UserDAO;
import archy.wiz.smaholdingsbackend.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User get(int id) {
		return sessionFactory.getCurrentSession().get(User.class,Integer.valueOf(id));
	}
	

	@Override
	public List<User> list() {
		return sessionFactory
				  .getCurrentSession()
				      .createQuery("FROM user" , User.class)
				        .getResultList();
	}
	
	
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory
			   .getCurrentSession()
			   .persist(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
