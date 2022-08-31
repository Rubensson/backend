
package com.portfolio.backendPortfolio.Repository;

import com.portfolio.backendPortfolio.Entity.Skills;
import java.util.Optional;
import javax.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer>{
    
    public Optional<Skills> findBySkillName(String skillName);
    public boolean existsBySkillName(String skillName);
   
}
