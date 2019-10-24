package com.stackroute.userprofileservice.controller;

import com.stackroute.userprofileservice.domain.User;
import com.stackroute.userprofileservice.service.RabbitMQSender;
import com.stackroute.userprofileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private UserService userService;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("userprofile")
    ResponseEntity<User> saveUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        userService.saveuser(user);
        responseEntity=new ResponseEntity<User>(user, HttpStatus.OK);

        rabbitMQSender.sendUser(user);
        return responseEntity;
    }

    @GetMapping("userprofile/{userName}")
    ResponseEntity<User> getUserByUserName(@PathVariable String userName)
    {
        ResponseEntity responseEntity;
        User user=userService.getUser(userName);
        responseEntity=new ResponseEntity<User>(user, HttpStatus.OK);
        return responseEntity;
    }



}
