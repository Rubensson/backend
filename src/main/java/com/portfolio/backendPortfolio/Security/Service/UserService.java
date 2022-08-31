
package com.portfolio.backendPortfolio.Security.Service;

import com.portfolio.backendPortfolio.Security.Entity.User;
import com.portfolio.backendPortfolio.Security.Repository.iUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
@Autowired
iUserRepository iuserRepository;

public Optional<User> getByUserName(String username){
return iuserRepository.findByUserName(username);
}

public boolean existsByUserName (String username){
    return iuserRepository.existsByUserName(username);
}

public boolean existsByEmail (String email){
    return iuserRepository.existsByEmail(email);
}
    
public void save (User user){
    iuserRepository.save(user);
}
}
