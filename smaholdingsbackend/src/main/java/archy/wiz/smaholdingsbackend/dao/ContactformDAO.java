package archy.wiz.smaholdingsbackend.dao;

import java.util.List;

import archy.wiz.smaholdingsbackend.dto.Contactform;

public interface ContactformDAO {

	Contactform get(int id);
	List<Contactform> list();
	List<Contactform> activeContactform();
	List<Contactform> activeContactformBycategory(int categoryId);
	
	boolean add(Contactform contactform);
	boolean update(Contactform contactform);
	boolean delete(Contactform contactform);	
}
