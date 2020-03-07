package com.limitservice.microservice.limitcontroller;


import com.limitservice.microservice.limitsservice.Configuration.ConfigurationPoint;

import com.limitservice.microservice.limitsservice.LimitsServiceCustomException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    ConfigurationPoint configurationPoint;

    @GetMapping("/limits")
    public ConfigurationPoint getLimitsValues(){

    return configurationPoint;

    }

    @GetMapping("/limitsexp")
    public void getLimitsValuesForException(){

        throw new LimitsServiceCustomException("This API Call Service Is Not Available");

//        return "Custom Exception";

//        return "TEST";

    }


    @GetMapping("/failmethod")
    @HystrixCommand(fallbackMethod = "failMethodBackup")
    public Object failureMethod(){

        throw  new RuntimeException("Error");
    }

    public ConfigurationPoint failMethodBackup(){

        return new ConfigurationPoint(123,456);
    }




}
