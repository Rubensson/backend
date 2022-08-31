
package com.portfolio.backendPortfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    
    private String skillName;
    private String description;
    private String skill_img;
    
    //Constructores

    public Skills() {
    }

    public Skills( String skillName, String description, String skill_img) {
      
        this.skillName = skillName;
        this.description = description;
        this.skill_img = skill_img;
    }

    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
