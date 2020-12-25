package archy.wiz.smaholdings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import archy.wiz.smaholdingsbackend.dao.BlogDAO;
import archy.wiz.smaholdingsbackend.dao.ContactformDAO;
import archy.wiz.smaholdingsbackend.dao.ProjectDAO;
import archy.wiz.smaholdingsbackend.dto.Blog;
import archy.wiz.smaholdingsbackend.dto.Contactform;
import archy.wiz.smaholdingsbackend.dto.Project;

@Controller
@RequestMapping("/json/data")
public class JasonDataController {
  
	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private ContactformDAO contactformDAO;
	
	@RequestMapping("/all/projects")
	@ResponseBody
	public  List<Project> getAllProjects(){
		return projectDAO.listActiveProjects();
	}
	
	
	@RequestMapping("/category/{id}/projects")
	@ResponseBody
	public  List<Project> getAllProjectsByCategory(@PathVariable int id){
		
		return projectDAO.listActiveProjectsByCategory(id);
	}
	
	
	@RequestMapping("/all/blogs")
	@ResponseBody
	public List<Blog> getAllBlogs(){
		return blogDAO.list();
	}
	
	@RequestMapping("/active/blogs")
	@ResponseBody
	public List<Blog> getActiveBlogs(){
		return blogDAO.listActiveBlogs();
	}
	
	@RequestMapping("/blogcategory/{id}/blogs")
	@ResponseBody
	public List<Blog> getBlogCategoryById(@PathVariable int id){
		return blogDAO.listActiveByBlogCategory(id);
	}
	
	
	@RequestMapping("/admin/all/projects")
	@ResponseBody
	public List<Project> getAllProjectForAdmin(){
		return projectDAO.list();
	}
	
	//getting latest 3  active projects to date 
	@RequestMapping("/latestprojects/projects")
	@ResponseBody
	public List<Project> getProjectByParam(){		
		return projectDAO.getProjectByParam("id", 3);
	}
	
	//getting the latest 3 active blogs to date
	@RequestMapping("/latestblogs/blogs")
	@ResponseBody
	public List<Blog> getAllBlogsByParam(){		
		return blogDAO.getBlogsByParam("id",3);		
	}
	
	
	//getting the latest 6 blogs
	@RequestMapping("/latest/blogs")
	@ResponseBody
	public List<Blog> getlatestActiveBlogs(){
		return blogDAO.getBlogsByParam("id", 6);
	}
	
	@RequestMapping("/contact")
	public List<Contactform> getactiveContactform(){
		return contactformDAO.activeContactform();
	}
	
	
}
