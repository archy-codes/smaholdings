package archy.wiz.smaholdings.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		   }
	   }
	   model.addObject("title","manage Projects");
	   return model;
   }
   
   //handling project submitting
   @RequestMapping(value="/projects", method=RequestMethod.POST)
   public String  handleProjectSubmission(@ModelAttribute("project") Project mProject ){
	  
	   logger.info(mProject.toString());
	   //create a new project record
	   projectDAO.add(mProject);
	   return "redirect:/manage/projects?operation=project";
   }
   
   
@ModelAttribute("categories")
public List<Category> getCategory(){
	return categoryDAO.list();
}
}
