package com.accounting.my.config.AuthServices;

import com.accounting.my.model.Users;
import com.accounting.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Balas on 3/30/2016.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Users user=userService.getUserByLogin(login);

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().getName()));

        UserDetails userDetails =  new org.springframework.security.core.userdetails.User(user.getLogin(),
                                                                            user.getPassword(),
                                                                            roles);
        return userDetails;
    }
}
