package com.stackroute.userprofileservice.service;


import com.stackroute.userprofileservice.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service()
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("register.exchange")
    private String exchange;

    @Value("userprofile.key")
    private String routingkey;

    public void sendUser(User user) {
        rabbitTemplate.convertAndSend(this.exchange,this.routingkey, user);
        System.out.println("Send User = " + user);
    }

}