package com.portfolio.backendPortfolio.Controller;

import com.portfolio.backendPortfolio.Dto.dtoSkills;
import com.portfolio.backendPortfolio.Entity.Skills;
import com.portfolio.backendPortfolio.Security.Contoller.Message;
import com.portfolio.backendPortfolio.Service.SkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "https://frtndportfolio.web.app")
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    @GetMapping("/list")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskSkills) {
        if (StringUtils.isBlank(dtoskSkills.getSkillName())) {
            return new ResponseEntity(new Message("Required skill name"), HttpStatus.BAD_REQUEST);
        }
        if (skillsService.existsBySkillName(dtoskSkills.getSkillName())) {
            return new ResponseEntity(new Message("Existent skill"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(dtoskSkills.getSkillName(), dtoskSkills.getDescription(), dtoskSkills.getSkill_img());
        skillsService.save(skills);

        return new ResponseEntity(new Message("Saved skills"), HttpStatus.OK);

    }
@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtosSkills) {

        //Validar existencia de Id
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Message("nonexistent id"), HttpStatus.BAD_REQUEST);
        }

        if (skillsService.existsBySkillName(dtosSkills.getSkillName()) && skillsService.getBySkillName(dtosSkills.getSkillName()).get().getId() != id) {
            return new ResponseEntity(new Message("Existen skills"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtosSkills.getSkillName())) {
            return new ResponseEntity(new Message("Required skill name"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = skillsService.getOne(id).get();
        skills.setSkillName(dtosSkills.getSkillName());
        skills.setDescription(dtosSkills.getDescription());
        skills.setSkill_img(dtosSkills.getSkill_img());

        skillsService.save(skills);
        return new ResponseEntity(new Message("Updated skill"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Message("Nonesxistent id"),HttpStatus.BAD_REQUEST);
        
        skillsService.delete(id);
        
        return new ResponseEntity(new Message("Deleted skill"),HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Message("Nonexistent"), HttpStatus.NOT_FOUND);
        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
}
