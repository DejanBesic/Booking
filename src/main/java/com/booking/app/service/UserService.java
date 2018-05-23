package com.booking.app.service;

import com.booking.app.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    User findByEmail(String email);
}
