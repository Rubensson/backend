package com.portfolio.backendPortfolio.Controller;

import com.portfolio.backendPortfolio.Dto.dtoEducation;
import com.portfolio.backendPortfolio.Entity.Education;
import com.portfolio.backendPortfolio.Security.Contoller.Message;
import com.portfolio.backendPortfolio.Service.EducationService;
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
@RequestMapping("/education")
@CrossOrigin(origins = "https://frtndportfolio.web.app")
//@CrossOrigin(origins ="http://localhost:4200")
public class EducationController {

    @Autowired
    EducationService educationService;

    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = educationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtosEducation) {
        if (StringUtils.isBlank(dtosEducation.getEducationName())) {
            return new ResponseEntity(new Message("Required education name"), HttpStatus.BAD_REQUEST);
        }
        if (educationService.existsByEducationName(dtosEducation.getEducationName())) {
            return new ResponseEntity(new Message("Existent education item"), HttpStatus.BAD_REQUEST);
        }

      Education education = new Education(dtosEducation.getEducationName(), dtosEducation.getDescription(), dtosEducation.getEducation_img());
        educationService.save(education);

        return new ResponseEntity(new Message("Saved education item"), HttpStatus.OK);

    }
@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtosEducation) {

        //Validar existencia de Id
        if (!educationService.existsById(id)) {
            return new ResponseEntity(new Message("nonexistent id"), HttpStatus.BAD_REQUEST);
        }

        if (educationService.existsByEducationName(dtosEducation.getEducationName()) && educationService.getByEducationName(dtosEducation.getEducationName()).get().getId() != id) {
            return new ResponseEntity(new Message("Existent education item"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtosEducation.getEducationName())) {
            return new ResponseEntity(new Message("Required education name"), HttpStatus.BAD_REQUEST);
        }

        Education education = educationService.getOne(id).get();
        education.setEducationName(dtosEducation.getEducationName());
        education.setDescription(dtosEducation.getDescription());
        education.setEducation_img(dtosEducation.getEducation_img());

        educationService.save(education);
        return new ResponseEntity(new Message("Updated education item"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!educationService.existsById(id))
            return new ResponseEntity(new Message("Nonesxistent id"),HttpStatus.BAD_REQUEST);
        
        educationService.delete(id);
        
        return new ResponseEntity(new Message("Deleted item"),HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!educationService.existsById(id))
            return new ResponseEntity(new Message("Nonexistent"), HttpStatus.NOT_FOUND);
        Education education = educationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
}
