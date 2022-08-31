
package com.portfolio.backendPortfolio.Interface;

import com.portfolio.backendPortfolio.Entity.Person;
import java.util.List;



public interface IPersonService {
   
    //Traigo una lista de persons
    public List<Person> getPersons();
   
    //Guardo un objeto de tipo Person
    public void savePerson (Person person);
    
    //Elimino un objeto Person, busco por id
    public void deletePerson (Long id);
    
    //Busco por id
    public Person findPerson(Long id);
}
