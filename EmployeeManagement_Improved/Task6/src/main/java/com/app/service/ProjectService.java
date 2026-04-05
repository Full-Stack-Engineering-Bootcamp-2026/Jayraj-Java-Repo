package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Project;
import com.app.repository.ProjectRepository;

@Service
public class ProjectService {

	private ProjectRepository repo;

	public ProjectService(ProjectRepository repo) {
		super();
		this.repo = repo;
	}
	
		
		public List<Project> findAll(){
			return repo.findAll();
		}
		
		
		public Project findById(Integer id) {
			return repo.findById(id).orElseThrow(() -> new RuntimeException("Project not Found"));
		}
		
		
		public Project save(Project project) {
			return repo.save(project);
		}
		
		
		public Project update(Integer id, Project project) {
			if(!repo.existsById(id))
				throw new RuntimeException("Project not Found");
			project.setId(id);
			
			return repo.save(project);
		}
		
		
	    public void delete(Integer id) {
	        if (!repo.existsById(id)) {
	            throw new RuntimeException("Project not found");
	        }
	        repo.deleteById(id);
	    }
	
}
