package archy.wiz.smaholdings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import archy.wiz.smaholdingsbackend.dao.CategoryDAO;
import archy.wiz.smaholdingsbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
  
  @RequestMapping(value= {"/","/index","/home"})
  public ModelAndView index() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","home");
	  model.addObject("userClicksHome",true);
	  model.addObject("categories",categoryDAO.list());
	  return model;
  }
  @RequestMapping(value= "/about")
  public ModelAndView about() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","about us");
	  model.addObject("userClicksAbout",true);
	  return model;
  }
  @RequestMapping(value= "/show/all/services")
  public ModelAndView shwoAllservices() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","services");
	  model.addObject("categories", categoryDAO.list());
	  model.addObject("userClicksServices",true);
	  return model;
  }
  @RequestMapping(value= "/show/category/{id}/services")
  public ModelAndView shwoCategoryservices(@PathVariable("id") int id) {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","services");
	  //fetching a category
	  Category category = null;
	  category = categoryDAO.get(id);
	  model.addObject("categories",category.getName());
	  model.addObject("category",category);
	  model.addObject("categories", categoryDAO.list());
	  model.addObject("userClicksCategoryServices",true);
	  return model;
  }
  @RequestMapping(value= "/projects")
  public ModelAndView projects() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","projects");
	  model.addObject("userClicksProjects",true);
	  return model;
  }
  
  @RequestMapping(value= "/contact")
  public ModelAndView contact() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","contact us");
	  model.addObject("userClicksContact",true);
	  return model;
  }
  @RequestMapping(value= "/blog")
  public ModelAndView blog() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","our blog");
	  model.addObject("userClicksBlog",true);
	  return model;
  }
}









