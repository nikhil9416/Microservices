package com.serviceone.folder.servicefirst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceFirstController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment environment;

    @GetMapping("/creater")
    public String getServiceFirstCall()

    {
        logger.info("Service First ----------------------->");
        return "Nikhil Chauhan Build This call" +" from port : "+environment.getProperty("local.server.port");
    }

}
