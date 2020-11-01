package archy.wiz.smaholdings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import archy.wiz.smaholdingsbackend.dao.ProjectDAO;
import archy.wiz.smaholdingsbackend.dto.Project;

@Controller
@RequestMapping("/json/data")
public class JasonDataController {
  
	@Autowired
	private ProjectDAO projectDAO;
	
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
	
}
