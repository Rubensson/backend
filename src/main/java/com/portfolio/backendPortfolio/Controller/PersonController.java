
package com.portfolio.backendPortfolio.Controller;

import com.portfolio.backendPortfolio.Entity.Person;
import com.portfolio.backendPortfolio.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frtndportfolio.web.app")
public class PersonController {
    @Autowired IPersonService iPersonService;
    
    //Declaro todos los metodos a usar
    
    @GetMapping ("/person/get")
    public List<Person> getPerson(){
        return iPersonService.getPersons();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/person/create")
    public String createPerson(@RequestBody Person person){
        iPersonService.savePerson(person);
        return"La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/person/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        iPersonService.deletePerson(id);
        return "La persona fue eliminada correctamente";
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/person/edit/{id}")
    public Person editPerson(@PathVariable Long id, @RequestParam ("name") String newName,@RequestParam ("location") String newLocation,
            @RequestParam ("profile_text") String newProfileText,@RequestParam ("email") String newEmail,@RequestParam ("position") String newPosition,
            @RequestParam ("hero_img") String newHeroImg,@RequestParam ("profile_img") String newProfileImg){
        
        Person person = iPersonService.findPerson(id);
        person.setName(newName);
        person.setLocation(newLocation);
        person.setEmail(newEmail);
                person.setPosition(newPosition);
                person.setHero_img(newHeroImg);
                person.setProfile_img(newProfileImg);
                person.setProfile_text(newProfileText);
                
                iPersonService.savePerson(person);
                return person;
    }
    @GetMapping ("/person/get/profile")
    public Person findPerson(){
    return iPersonService.findPerson((long)1);
}

}
