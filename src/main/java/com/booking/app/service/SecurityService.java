package com.booking.app.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
    
    UserDetails login(String username, String password);
}
