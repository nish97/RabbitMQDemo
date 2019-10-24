package com.stackroute.userprofileservice.service;

import com.stackroute.userprofileservice.domain.User;
import com.stackroute.userprofileservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveuser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUserName(username);
    }
}
