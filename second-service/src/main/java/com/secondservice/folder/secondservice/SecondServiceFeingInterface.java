package com.secondservice.folder.secondservice;//package com.servicesecond.folder.servicesecond;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//This one used when we don't use Ribbon For load balancing and We don't have eureka server
//@FeignClient(name="service-first",url = "localhost:9191")

//This is require when we are using ribbon for load balancing and if don't have eureka server
//then we have to define all instance of the service, whom we are call using ribbon, in application.properties file
//Or we have to create eureka server from where ribbon can get the all instance of service, to where ribbon is doing load balancing.
//@FeignClient(name="service-first")

@FeignClient(name="zuul-server")
@RibbonClient(name="service-first")
public interface SecondServiceFeingInterface {


    @RequestMapping(method = RequestMethod.GET, value="/service-first/creater")
    public String makeFeignCallToFirdtService();



}
