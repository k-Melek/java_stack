package com.melek.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melek.projectmanager.models.Project;
import com.melek.projectmanager.models.User;
import com.melek.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> findAll(){
		return projectRepository.findAll();
	}
	// List of projects user joined
	public List<Project> findJoinedProjects(User user){
		return projectRepository.findAllByUsers(user);
	}
	// List of projects user didn't join
	public List<Project> findNotJoinedProjects(User user){
		return projectRepository.findByUsersNotContains(user);
	}
	// Create project
	public Project createProject(Project newProject) {
		return projectRepository.save(newProject);
	}
	// find Project by ID
	public Project findOneProject(Long id) {
		Optional<Project> maybeProject = projectRepository.findById(id);
		if(maybeProject.isPresent()) {
			return maybeProject.get();
		} else {
			return null;
		}
	}
	
	// update project
	public Project updateProject(Project updatedProject) {
		return projectRepository.save(updatedProject);
	}
	
	// Delete project
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}
	
	
	
	
}
