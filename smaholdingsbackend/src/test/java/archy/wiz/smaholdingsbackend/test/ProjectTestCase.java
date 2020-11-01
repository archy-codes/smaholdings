package archy.wiz.smaholdingsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import archy.wiz.smaholdingsbackend.dao.ProjectDAO;
import archy.wiz.smaholdingsbackend.dto.Project;

public class ProjectTestCase {
	
 private static AnnotationConfigApplicationContext context;
 private static ProjectDAO projectDAO;
 private Project project;
 
 
 @BeforeClass
 public static  void init() {
	 context = new AnnotationConfigApplicationContext();
	 context.scan("archy.wiz.smaholdingsbackend");
	 context.refresh();
	 projectDAO = (ProjectDAO)context.getBean("projectDAO");
	 
 }
 @Test
 public void CRUDTestCase() {
	 project = new Project();
	 project.setProjectName("Pax Water Supply");
	 project.setClient("Polokwane Municipal");
	 project.setDescription("supply of uPVC Pipes and Galvanising Pipes for Steel Tank");
	 project.setValue(2123000);
	 project.setContactDetails("Mr B Shipalana 0725542428");
	 project.setStatus("completed");
	 project.setActive(true);
	 project.setCategoryId(1);
	 project.setAdminId(1);
	 assertEquals("something went wrong inerting a new product!",true,projectDAO.add(project));
	 
	 
	 project = new Project();
	 project.setProjectName("IRPTS from vermikuliet street to Zebediela Street");
	 project.setClient("Polokwane Municipal");
	 project.setDescription("supply of Concrete Kerbing and Road Signs");
	 project.setValue(126000); 
	 project.setContactDetails("Mr B Shipalana 0725542428");
	 project.setStatus("completed");
	 project.setActive(true);
	 project.setCategoryId(1);
	 project.setAdminId(2);
	 assertEquals("something went wrong inerting a new produc!",true,projectDAO.add(project));
	 
	 project = new Project();
	 project.setProjectName("Thohoyandou Water Purification and Wastewater Treatment Plant");
	 project.setClient("National Department of Public Works");
	 project.setDescription("Supply of uPVC Pipes, Steel Pipes and Stormwater Pipes");
	 project.setValue(5350000);
	 project.setContactDetails("Mr B Shipalana  0725542428");
	 project.setStatus("completed");
	 project.setActive(true);
	 project.setCategoryId(1);
	 project.setAdminId(1);
	 assertEquals("something went wrong inerting a new produc",true,projectDAO.add(project));
	 
	 project = new Project();
	 project.setProjectName("Cambrian Cementry");
	 project.setClient("Ekurhuleni Municipal");
	 project.setDescription("Supply of uPVC pipes and Stormwater Pipes");
	 project.setValue(465000);
	 project.setContactDetails("Mr R Nemavhidi   0791953870");
	 project.setStatus("completed");
	 project.setActive(true);
	 project.setCategoryId(1);
	 project.setAdminId(2);
	 assertEquals("something went wrong inerting a new produc!",true,projectDAO.add(project));
	 
	 project = new Project();
	 project.setProjectName("Rehabilitation and Maintanance of Road in Northam");
	 project.setClient("Ral");
	 project.setDescription("Accredited Training");
	 project.setValue(152000);
	 project.setContactDetails("Mr Khumbudzo Sikhitha   0721358594");
	 project.setStatus("completed");
	 project.setActive(true);
	 project.setCategoryId(6);
	 project.setAdminId(1);
	 assertEquals("something went wrong inerting a new produc!",true,projectDAO.add(project));
	  
	 project = new Project();
	 project.setProjectName("Rehabilitation");
	 project.setClient("Ral");
	 project.setDescription("Training");
	 project.setValue(152000);
	 project.setContactDetails("Mr Khumbudzo Sikhitha   0721358594");
	 project.setStatus("completed");
	 project.setActive(true);
	 project.setCategoryId(1);
	 project.setAdminId(1);
	 assertEquals("something went wrong inerting a new produc!",true,projectDAO.add(project));

	 
	 //updating a project
	 project = projectDAO.get(6);
	 project.setProjectName("mbulungeni mulaudzi archybald");
	 project.setClient("mulaudzi archy archy");
	 project.setDescription("Training the best training ever");
	 project.setValue(2747464);
	 project.setContactDetails("Mr Mulaudzi   00767289561");
	 project.setStatus("completed");
	 project.setActive(true);
	 project.setCategoryId(1);
	 project.setAdminId(1);
	 assertEquals("Something went wrong while updating  the project ",true,projectDAO.update(project));
	 
	 //deleting a project in the table
	 assertEquals("Something went wrong while deleting  the project ",true,projectDAO.delete(project));
	 
	 //fetching the list in the table
	 assertEquals("Something went wrong while fetching the  list of projects!",6,projectDAO.list().size());
	 
	//fetching the list in the table
	 assertEquals("Something went wrong while fetching the  list of projects!",5,projectDAO.listActiveProjects().size());
			 
	 //fetching list of active projects by category
	 assertEquals("Something went wrong while fetching the  list of projects!",4,projectDAO.listActiveProjectsByCategory(1).size());
	 assertEquals("Something went wrong while fetching the  list of projects!",1,projectDAO.listActiveProjectsByCategory(6).size());

	 //fetching list of latest active projects
	 assertEquals("Something went wrong while fetching the  list of projects!",5,projectDAO.listLatestActiveProjects(5).size());
	 
 }
 
}