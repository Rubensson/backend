
package com.portfolio.backendPortfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    
    private String projectName;
    private String description;
    private String project_img;
    
    //Constructores

   


    public Project() {
    }

    public Project(String projectName, String description, String project_img) {
       
        this.projectName = projectName;
        this.description = description;
        this.project_img = project_img;
    }

      //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject_img() {
        return project_img;
    }

    public void setProject_img(String project_img) {
        this.project_img = project_img;
    }
    
    
}

 