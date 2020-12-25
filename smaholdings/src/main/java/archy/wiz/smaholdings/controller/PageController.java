package archy.wiz.smaholdings.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import archy.wiz.smaholdings.exception.ProjectNotFoundException;
import archy.wiz.smaholdingsbackend.dao.BlogCategoryDAO;
import archy.wiz.smaholdingsbackend.dao.BlogDAO;
import archy.wiz.smaholdingsbackend.dao.CategoryDAO;
import archy.wiz.smaholdingsbackend.dao.ContactformDAO;
import archy.wiz.smaholdingsbackend.dao.ProjectDAO;
import archy.wiz.smaholdingsbackend.dao.ServicesDAO;
import archy.wiz.smaholdingsbackend.dao.ServicesMenuDAO;
import archy.wiz.smaholdingsbackend.dto.Blog;
import archy.wiz.smaholdingsbackend.dto.BlogCategory;
import archy.wiz.smaholdingsbackend.dto.Category;
import archy.wiz.smaholdingsbackend.dto.Contactform;
import archy.wiz.smaholdingsbackend.dto.Project;
import archy.wiz.smaholdingsbackend.dto.ServicesMenu;

@Controller
public class PageController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
    @Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private BlogCategoryDAO blogCategoryDAO;
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private ServicesDAO servicesDAO;
	
	@Autowired
	private ContactformDAO contactformDAO;
	
	@Autowired
	private ServicesMenuDAO servicesMenuDAO;
	
  
	//handling the landing page
  @RequestMapping(value= {"/","/index","/home"})
  public ModelAndView index() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","home");
	  
	  logger.info("Inside PageController index method - INFO");
	  logger.debug("Inside PageController index method - DEBUG");
	  
	  model.addObject("userClicksHome",true);
	  model.addObject("categories",categoryDAO.list());
	  model.addObject("servicesinfo", servicesDAO.getActiveServices());
	  return model;
  }
  
  //about us page
  @RequestMapping(value= "/about")
  public ModelAndView about() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","about us");
	  model.addObject("userClicksAbout",true);
	  return model;
  }
  
  //showing all the projects
  @RequestMapping(value= "/all/projects")
  public ModelAndView showAllProjects() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","projects");
	  model.addObject("categories", categoryDAO.list());
	  model.addObject("userClicksProjects",true);
	  return model;
  }
  
  //showing the gallery
  @RequestMapping(value= "/gallery")
  public ModelAndView gallery() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","gallery");
	  model.addObject("userClicksGallery",true);
	  return model;
  }
  
  
   //showing blogs based on the category
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
  
  //method to show all the blogs
  @RequestMapping(value= "/show/all/blogs")
  public ModelAndView showAllblogs() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","all blogs");	
	  model.addObject("blogs", blogDAO.listActiveBlogs());
	  model.addObject("userClicksBlogs",true);
	  model.addObject("blogcategories",blogCategoryDAO.list());
	  return model;
  }
  
  //showing blog based on the category
  @RequestMapping(value= "/show/blogcategory/{id}/blogs")
  public ModelAndView showCategoryBlog(@PathVariable("id") int id) {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","blog");
	  BlogCategory blogcategory = null;
	  blogcategory = blogCategoryDAO.get(id);
	  model.addObject("blogcategories",blogcategory.getName());
	  model.addObject("blogcategory",blogcategory);
	  model.addObject("blogcategories", blogCategoryDAO.list());
	  model.addObject("userClicksCategoryBlogs",true);
	  return model;
  }
    
 
  //handling services section
  @RequestMapping(value= "/services")
  public ModelAndView services(){
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","services");
	  model.addObject("servicesinfo", servicesDAO.getActiveServices());
	  model.addObject("userClicksServices",true);
	  return model;
  }
  
  @RequestMapping(value = "/more/services/more")
  public ModelAndView ser(){
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","more services");
	  model.addObject("userClickMoreServices",true);
	  return model;
  }
  
  //single page services
  @RequestMapping(value="/category/{id}/services")
  public ModelAndView singleService(@PathVariable("id") int id) {
	  ModelAndView model = new ModelAndView("page");
	  ServicesMenu servicesMenu = null;
	  servicesMenu = servicesMenuDAO.get(id);
	  model.addObject("title",servicesMenu.getName());
	  model.addObject("servicesMenu",servicesMenu);
	  model.addObject("servicesinfo", servicesDAO.getActiveServices());
	  return model;
  }
  
  
  //handling contact form section
  @RequestMapping(value= "/contact", method=RequestMethod.GET)
  public ModelAndView contact(@RequestParam(name="operation", required=false) String operation) {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","contact us");
	  Contactform newcontactform = new Contactform();
	  newcontactform.setActive(true);
	  model.addObject("contact",newcontactform);
	  if(operation!=null) {
		  if(operation.equals("contact")) {
			  model.addObject("message","contact form submitted successfully");
		  }
	  }
	  model.addObject("userClicksContact",true);
	  return model;
  }
  
  //handling contactform submission
  @RequestMapping(value="/contact", method=RequestMethod.POST)
  public String handleContactSubmission(@Valid @ModelAttribute("contact") Contactform mContactform ,BindingResult results , Model model){
	  //creating a new contactform record
	  if(results.hasErrors()) {
		  
		  model.addAttribute("userClicksContact",true);
		  model.addAttribute("title", "contact");
		  model.addAttribute("message", "failed submit the contact form");
		  return "page";
	  }
	  logger.info(mContactform.toString());
	  contactformDAO.add(mContactform);
	  return "redirect:/contact?operation=contact";
  }
  
  
  //returning the list of categories
  @ModelAttribute("categories")
  public List<Category> getCategories(){
	  return categoryDAO.listActiveCategories();
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
  
  
  
  //showing a single blog page
  @RequestMapping(value="/show/{id}/blog")
  public ModelAndView singlePageBlog(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("page");
	  Blog blog = blogDAO.get(id);
	  model.addObject("title",blog.getName());
	  model.addObject("blog",blog);
	  model.addObject("userClickShowBlog",true);
	  return model;
  }
  
  
  
  //handling more services section
  @RequestMapping(value="/show/more/services")
  public ModelAndView showCategoryServices() {
	  ModelAndView model = new ModelAndView("page");
	  model.addObject("title","more services");
	  model.addObject("userClickShowCategoryService",true);
	  return model;
  }

//backend contact us table handling
@RequestMapping(value="/contactInfo")
public ModelAndView showContactinfoTable() {
	ModelAndView model = new ModelAndView("page");
	model.addObject("title","contact-info");
	model.addObject("userClickContactInfoTable", true);
	model.addObject("categories",categoryDAO.list());
	return model;
}

/*access denied */
@RequestMapping(value="/access-denied")
public ModelAndView accessDenied() {
	ModelAndView model = new ModelAndView("error");
	model.addObject("title","access-denied");
	model.addObject("ErrorTitle", "you do not have access to this service, contact your administrator!!");
	model.addObject("errorDescription","you are not authorized to view this page!");
	return model;
}


//login handling in the backend
@RequestMapping(value="/login")
public ModelAndView smaLoginForm(@RequestParam(name="error", required = false) String error){
	ModelAndView model = new ModelAndView("smalog");
	model.addObject("title","login");
	if(error!=null) {
		model.addObject("message","Enter Valid Username and Password !!");
	}
	return model;
}



}







