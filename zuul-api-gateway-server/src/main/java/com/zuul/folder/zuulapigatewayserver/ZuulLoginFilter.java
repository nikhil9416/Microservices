package com.zuul.folder.zuulapigatewayserver;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class ZuulLoginFilter extends ZuulFilter {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        //There are three type of filterType
        //1. pre -> If want to execute filter before every request
        //2.post -> If we want to execute filter after every request
        //3.error -> If we want to execute filter when we get any error in request execution

        return "pre";
    }

    @Override
    public int filterOrder() {
        // If we have multiple zuul server for different-2 purpose then we can define execution or flow of request
        // among of these zuul gateway by defining the value in this attribute or method
        // Like if we have one Zuul gateway who handle login process for each and every API
        //and we have one more zuul gateway for authentication process for each request then
        //we define there execution order by this method, If we want to execute login zuul gateway first
        //then set here 0 and in authentication zuul gateway define this method with 1 and then
        //request will first come to login zuul and then send to authentication zuul.

        return 1;
    }

    @Override
    public boolean shouldFilter() {
//        return false;
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        //This is the place where we add filter logic

       HttpServletRequest httpServletRequest= RequestContext.getCurrentContext().getRequest();

       logger.info("Request is this ---> "+httpServletRequest+" "+httpServletRequest.getRequestURI());

        return null;
    }
}
