package com.stackroute.userprofileservice.service;

import com.stackroute.userprofileservice.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class RabbitMQReciever {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RabbitListener(queues = "user-profile")
    public void receive(User user)
    {
        userService.saveuser(user);

        System.out.println("Recieved User"+user.toString());
    }

}
