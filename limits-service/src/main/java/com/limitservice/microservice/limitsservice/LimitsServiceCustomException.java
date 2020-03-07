package com.limitservice.microservice.limitsservice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LimitsServiceCustomException extends RuntimeException{

    public LimitsServiceCustomException(String message){

        super(message);

    }

}
