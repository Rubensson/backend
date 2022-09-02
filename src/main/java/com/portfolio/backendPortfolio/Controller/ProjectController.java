package com.portfolio.backendPortfolio.Controller;

import com.portfolio.backendPortfolio.Dto.dtoProject;

import com.portfolio.backendPortfolio.Entity.Project;

import com.portfolio.backendPortfolio.Security.Contoller.Message;
import com.portfolio.backendPortfolio.Service.ProjectService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "https://frtndportfolio.web.app")
//@CrossOrigin(origins ="http://localhost:4200")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = projectService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProject dtosProject) {
        if (StringUtils.isBlank(dtosProject.getProjectName())) {
            return new ResponseEntity(new Message("Required project name"), HttpStatus.BAD_REQUEST);
        }
        if (projectService.existsByProjectName(dtosProject.getProjectName())) {
            return new ResponseEntity(new Message("Existent project"), HttpStatus.BAD_REQUEST);
        }

        Project project = new Project(dtosProject.getProjectName(), dtosProject.getDescription(), dtosProject.getProject_img());
        projectService.save(project);

        return new ResponseEntity(new Message("Saved project"), HttpStatus.OK);

    }
@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProject dtosProject) {

        
        if (!projectService.existsById(id)) {
            return new ResponseEntity(new Message("nonexistent id"), HttpStatus.BAD_REQUEST);
        }

        if (projectService.existsByProjectName(dtosProject.getProjectName()) && projectService.getByProjectName(dtosProject.getProjectName()).get().getId() != id) {
            return new ResponseEntity(new Message("Existing project"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtosProject.getProjectName())) {
            return new ResponseEntity(new Message("Required project name"), HttpStatus.BAD_REQUEST);
        }

        Project project = projectService.getOne(id).get();
        project.setProjectName(dtosProject.getProjectName());
        project.setDescription(dtosProject.getDescription());
        project.setProject_img(dtosProject.getProject_img());

        projectService.save(project);
        return new ResponseEntity(new Message("Updated project"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!projectService.existsById(id))
            return new ResponseEntity(new Message("Nonesxistent id"),HttpStatus.BAD_REQUEST);
        
        projectService.delete(id);
        
        return new ResponseEntity(new Message("Deleted project"),HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id){
        if(!projectService.existsById(id))
            return new ResponseEntity(new Message("Nonexistent"), HttpStatus.NOT_FOUND);
        Project project = projectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
}
