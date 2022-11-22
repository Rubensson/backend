
package com.portfolio.backendPortfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    
    private String educationName;
    private String description;
    private String education_img;
    
    
    //Constructor

    public Education() {
    }

    public Education(String educationName, String description, String education_img) {
       
        this.educationName = educationName;
        this.description = description;
        this.education_img = education_img;
    }

    

   //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEducation_img() {
        return education_img;
    }

    public void setEducation_img(String education_img) {
        this.education_img = education_img;
    }
    
    
         
    
}
