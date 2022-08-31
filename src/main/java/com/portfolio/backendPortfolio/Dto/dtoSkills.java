
package com.portfolio.backendPortfolio.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkills {
    
    @NotBlank
    private String skillName;
    
    @NotBlank
    private String description;
    
    @NotBlank
    private String skill_img;
 
    //Constructors

    public dtoSkills() {
    }

    public dtoSkills(String skillName, String description, String skill_img) {
        this.skillName = skillName;
        this.description = description;
        this.skill_img = skill_img;
    }
    
    //Getter and Setter

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkill_img() {
        return skill_img;
    }

    public void setSkill_img(String skill_img) {
        this.skill_img = skill_img;
    }
    
}
