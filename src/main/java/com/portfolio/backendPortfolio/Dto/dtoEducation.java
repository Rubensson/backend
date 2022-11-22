
package com.portfolio.backendPortfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducation {
    
    @NotBlank
    private String educationName;
    
    @NotBlank
    private String description;
    
    @NotBlank
    private String education_img;
 
    //Constructors

     public dtoEducation() {
    }

     public dtoEducation(String educationName, String description, String education_img) {
        this.educationName = educationName;
        this.description = description;
        this.education_img = education_img;
    }
    //Getter and Setter

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
