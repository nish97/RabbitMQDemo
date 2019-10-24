package com.stackroute.userprofileservice.service;

import com.stackroute.userprofileservice.domain.User;

public interface UserService {
    public User saveuser(User user);
    public User getUser(String username);
}
