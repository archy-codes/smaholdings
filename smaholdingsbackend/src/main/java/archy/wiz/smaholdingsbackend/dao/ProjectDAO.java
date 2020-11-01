package archy.wiz.smaholdingsbackend.dao;

import java.util.List;

import archy.wiz.smaholdingsbackend.dto.Project;

public interface ProjectDAO {
	
  Project get(int id);
  List<Project> list();
  boolean add(Project project);
  boolean update(Project project);
  boolean delete(Project project);
  
  List<Project> listActiveProjects();
  List<Project> listActiveProjectsByCategory(int categoryId);
  List<Project> listLatestActiveProjects(int count);
}
