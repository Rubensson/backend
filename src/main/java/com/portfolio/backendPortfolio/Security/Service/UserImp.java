
package com.portfolio.backendPortfolio.Security.Service;

import com.portfolio.backendPortfolio.Security.Entity.PrincipalUser;
import com.portfolio.backendPortfolio.Security.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service

public class UserImp implements UserDetailsService{
    
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = userService.getByUserName(userName).get();
    return PrincipalUser.build(user);
    }
    
    
}
