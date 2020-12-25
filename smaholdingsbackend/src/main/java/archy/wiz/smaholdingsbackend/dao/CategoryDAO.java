package archy.wiz.smaholdingsbackend.dao;

import java.util.List;

import archy.wiz.smaholdingsbackend.dto.Category;

public interface CategoryDAO {
	
   Category get(int id);
   List<Category> list();
   List<Category> listActiveCategories();
   boolean add(Category category);
   boolean update(Category category); 
   boolean delete(Category category); 
}
