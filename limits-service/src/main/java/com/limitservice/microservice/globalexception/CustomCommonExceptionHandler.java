package com.limitservice.microservice.globalexception;


import com.limitservice.microservice.limitsservice.LimitsServiceExceptionFormate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Set;

@RestController
@ControllerAdvice(value = "com.limitservice.microservice")
public class CustomCommonExceptionHandler extends ResponseEntityExceptionHandler {

    Log logger = LogFactory.getLog(this.getClass());


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){

//        LimitsServiceExceptionFormate exception=new LimitsServiceExceptionFormate("abcd","asdas",new Date());
        LimitsServiceExceptionFormate exception=new LimitsServiceExceptionFormate();
            exception.setDate(new Date());
            exception.setDetails(request.getDescription(false));
            exception.setMessage(ex.getMessage());
        logger.info("Sala nahi aaya abhi yaha ");

        return new ResponseEntity(exception,HttpStatus.NOT_FOUND);
    }

}
