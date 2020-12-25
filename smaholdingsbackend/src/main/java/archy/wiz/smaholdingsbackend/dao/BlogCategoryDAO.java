package archy.wiz.smaholdingsbackend.dao;

import java.util.List;

import archy.wiz.smaholdingsbackend.dto.BlogCategory;

public interface BlogCategoryDAO {

	List<BlogCategory> list();
	BlogCategory get(int id);
	boolean add(BlogCategory blogCategory);
	boolean update(BlogCategory blogCategory);
	boolean delete(BlogCategory blogCategory);
	
}
