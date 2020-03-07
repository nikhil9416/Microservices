package com.limitservice.microservice.limitsservice.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

public class limitsconfig {

    private int minimum;
    private int maximum;

    public limitsconfig() {
    }

    public limitsconfig(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}
