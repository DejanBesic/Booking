package com.booking.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booking.app.model.Role;
import com.booking.app.model.User;
import com.booking.app.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        if(user == null)
        	throw new org.springframework.security.core.userdetails.UsernameNotFoundException("User does not exist");
        	
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
        	if(!role.getName().equals("REGULAR"))
                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), false, true, true, true, grantedAuthorities);

            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, grantedAuthorities);
    }
}
