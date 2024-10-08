package com.microservices.department_service.controllers;

//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${myproperty}")
    private String props;


    @GetMapping("/message")
    public String getMyProperty(){
        return props;
    }
}
