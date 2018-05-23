package com.booking.app.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
