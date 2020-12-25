package archy.wiz.smaholdings.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import archy.wiz.smaholdings.util.FileUploadUtility;
import archy.wiz.smaholdings.validator.ProjectValidator;
import archy.wiz.smaholdingsbackend.dao.CategoryDAO;
import archy.wiz.smaholdingsbackend.dao.ProjectDAO;
import archy.wiz.smaholdingsbackend.dto.Category;
import archy.wiz.smaholdingsbackend.dto.Project;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProjectDAO projectDAO;
		
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	

	
   @RequestMapping(value="/projects", method=RequestMethod.GET)
   public ModelAndView showManageProjects(@RequestParam(name="operation", required=false) String operation ){
	  
	   ModelAndView model = new ModelAndView("page");
	   model.addObject("userClickManageProjects",true);
	   
	   Project nproject = new Project();
	   nproject.setAdminId(1);
	   nproject.setActive(true);
	   model.addObject("project", nproject);
	   
	   if(operation != null) {
		   if(operation.equals("project")) {
			   model.addObject("message","project Submitted Successfully");
		   }else if(operation.equals("category")) {
			   model.addObject("message","Category Submitted Successfully");
		   }
	   }
	   model.addObject("title","manage Projects");
	   return model;
   }
	 
	 
   
   //handling project submitting
   @RequestMapping(value="/projects", method=RequestMethod.POST)
   public String  handleProjectSubmission(@Valid @ModelAttribute("project") Project mProject, BindingResult result , Model model, HttpServletRequest request  ){
	  
	   if(mProject.getId() == 0) {
	      new ProjectValidator().validate(mProject,result);
	     }else {
	    	 if(!mProject.getFile().getOriginalFilename().equals("")) {
	    		 new ProjectValidator().validate(mProject, result);
	    	 }
	     }
	   
	   //chcking if there any errors
	   if(result.hasErrors()) {
		   model.addAttribute("title","manage projects");
		   model.addAttribute("userClickManageProjects",true);
		   model.addAttribute("message","validation for project submission failed");
		   return "page";
	   }
	   
	   logger.info(mProject.toString());
	   //create a new project record
	  if(mProject.getId() == 0) {
	      projectDAO.add(mProject);
	  }else {
		  projectDAO.update(mProject);
	  }
	   
	   
	   if(!mProject.getFile().getOriginalFilename().equals("")) {
		   FileUploadUtility.uploadFile(request,mProject.getFile(),mProject.getCode());
	   }
	   
	   return "redirect:/manage/projects?operation=project";
   }
    
   
   @RequestMapping(value="/{id}/project",method=RequestMethod.GET)
   public ModelAndView showManageProjectEdit(@PathVariable int id){
		  
	   ModelAndView model = new ModelAndView("page");
	   model.addObject("userClickManageProjects",true);
	   Project nProject = projectDAO.get(id);
	   nProject.setActive(true);
	   model.addObject("project", nProject);
	   model.addObject("title","manage Projects");
	   return model;
   }
   
   
   
   @RequestMapping(value = "/project/{id}/activation", method=RequestMethod.POST)
   @ResponseBody
   public String handleProjectActivation(@PathVariable int id) {
	    Project project = projectDAO.get(id);
	    boolean isActive = project.isActive();
	    //handling project activation on the value
	    project.setActive(!project.isActive());
	    //updating the project
	    projectDAO.update(project);
	    
	    
	   return (isActive)? "you have successfully deactivated the project with the id " + project.getId()
	   : "you have successfully activated the project with id " + project.getId();
   }
   
   
   //handling category submission
   @RequestMapping(value="/category", method=RequestMethod.POST)
   public String handleCategorySubmission(@ModelAttribute Category category) {
	   categoryDAO.add(category);
	   return "redirect:/manage/projects?operation=category";
   }
   
   
   
@ModelAttribute("categories")
public List<Category> getCategories(){
	return categoryDAO.list();
}

@ModelAttribute("category")
public Category getCategory(){
	return new Category();
}


}
