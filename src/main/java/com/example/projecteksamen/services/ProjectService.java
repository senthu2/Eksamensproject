package com.example.projecteksamen.services;

import com.example.projecteksamen.models.Gallery;
import com.example.projecteksamen.models.Project;
import com.example.projecteksamen.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public void save(Project project){
        projectRepository.save(project);
    }

    public void saveAll(List<Project> projects){
        projectRepository.saveAll(projects);
    }

    public Project fetchById(int id){
        Optional<Project> optional = projectRepository.findById(id);
        return optional.get();
    }

    public List<Project> fetchAll(){
        return projectRepository.findAll();
    }

    public void delete(Project project){
        projectRepository.delete(project);
    }
}
