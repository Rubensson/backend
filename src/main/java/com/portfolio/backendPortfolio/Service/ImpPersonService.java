
package com.portfolio.backendPortfolio.Service;

import com.portfolio.backendPortfolio.Entity.Person;
import com.portfolio.backendPortfolio.Interface.IPersonService;
import com.portfolio.backendPortfolio.Repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonService implements IPersonService{

    @Autowired IPersonRepository iPeronRepository;
    @Override
    
    public List<Person> getPersons() {
        List<Person> person = iPeronRepository.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
    iPeronRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
       iPeronRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
    Person person = iPeronRepository.findById(id).orElse(null);
    return person;
    }
    
}
