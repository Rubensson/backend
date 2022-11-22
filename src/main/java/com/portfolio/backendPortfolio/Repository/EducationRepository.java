
package com.portfolio.backendPortfolio.Repository;

import com.portfolio.backendPortfolio.Entity.Education;
import java.util.Optional;
import javax.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{
    
    public Optional<Education> findByEducationName(String educationName);
    public boolean existsByEducationName(String educationName);
   
}
