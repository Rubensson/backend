
package com.portfolio.backendPortfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProject {
    
    @NotBlank
    private String projectName;
    
    @NotBlank
    private String description;
    
    @NotBlank
    private String project_img;
 
    //Constructors

    public dtoProject() {
    }

    public dtoProject(String projectName, String description, String project_img) {
        this.projectName = projectName;
        this.description = description;
        this.project_img = project_img;
    }

    
    
    //Getters and Setters

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
