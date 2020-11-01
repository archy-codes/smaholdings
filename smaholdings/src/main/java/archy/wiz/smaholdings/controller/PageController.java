package archy.wiz.smaholdings.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import archy.wiz.smaholdings.exception.ProjectNotFoundException;
import archy.wiz.smaholdingsbackend.dao.CategoryDAO;
import archy.wiz.smaholdingsbackend.dao.ProjectDAO;
import archy.wiz.smaholdingsbackend.dto.Category;
import archy.wiz.smaholdingsbackend.dto.Project;

@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
    @Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProjectDAO projectDAO;
	
  
  @RequestMapping(value= {"/","/index","/home"})
  public ModelAndView index() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","home");
	  
	  logger.info("Inside PageController index method - INFO");
	  logger.debug("Inside PageController index method - DEBUG");
	  
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
  @RequestMapping(value= "/show/all/projects")
  public ModelAndView showAllProjects() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","projects");
	  model.addObject("categories", categoryDAO.list());
	  model.addObject("userClicksProjects",true);
	  return model;
  }
  
  
  
  @RequestMapping(value= "/show/category/{id}/projects")
  public ModelAndView showCategoryProjects(@PathVariable("id") int id) {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","projects");
	  Category category = null;
	  category = categoryDAO.get(id);
	  model.addObject("categories",category.getName());
	  model.addObject("category",category);
	  model.addObject("categories", categoryDAO.list());
	  model.addObject("userClicksCategoryProjects",true);
	  return model;
  }
  
  @RequestMapping(value= "/services")
  public ModelAndView services(){
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","services");
	  model.addObject("userClicksServices",true);
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

  
  
  
  //showing a single page for the project
  @RequestMapping(value="/show/{id}/project")
  public ModelAndView singlePageProject(@PathVariable("id") int id) throws ProjectNotFoundException {
	  ModelAndView model = new ModelAndView("page");
	  Project project = projectDAO.get(id);
	  if(project == null)throw new ProjectNotFoundException(); 
	  model.addObject("title",project.getProjectName());
	  model.addObject("project",project);
	  model.addObject("userClickShowProject",true);
	  return model;
  }
  
  
  @RequestMapping(value="/show/more/services")
  public ModelAndView showCategoryServices() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","more services");
	  model.addObject("userClickShowCategoryService",true);
	  return model;
  }
}









