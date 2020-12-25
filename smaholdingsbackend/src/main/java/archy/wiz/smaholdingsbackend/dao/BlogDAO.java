package archy.wiz.smaholdingsbackend.dao;

import java.util.List;

import archy.wiz.smaholdingsbackend.dto.Blog;

public interface BlogDAO {

	Blog get(int id);
	boolean add(Blog blog);
	boolean update(Blog blog);
	boolean delete(Blog blog);
	List<Blog> list();
	List<Blog> listActiveBlogs();
	List<Blog> listActiveByBlogCategory(int blogCategoryId);
	List<Blog> listLatestActiveBlogs(int count);
	List<Blog> getBlogsByParam(String param, int count);
	
}
