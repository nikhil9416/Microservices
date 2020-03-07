package com.secondservice.folder.secondservice.controller;//package com.servicesecond.folder.servicesecond.secondservice;


import com.secondservice.folder.secondservice.SecondServiceFeingInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondServiceController {

    @Autowired
    SecondServiceFeingInterface secondServiceFeingInterface;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping("/servicecreater")
    public String secondServiceGetCall(){

        String result=secondServiceFeingInterface.makeFeignCallToFirdtService();

        logger.info(" Second Service ------------------------------>"+result);
        return result;

    }

}
