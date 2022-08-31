
package com.portfolio.backendPortfolio.Repository;

import com.portfolio.backendPortfolio.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPersonRepository extends JpaRepository<Person, Long>{
    
}
