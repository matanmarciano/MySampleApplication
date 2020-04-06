package com.sample.application.configuration;

import com.sample.application.engines.IEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@ConfigurationProperties
public class EngineConfiguration {
    private MyObject myObject;
    private Map<String, IEngine> engines;

    @Autowired
    public EngineConfiguration(@Qualifier("myObject") MyObject myObject, Map<String, IEngine> engines) {
        this.myObject = myObject;
        this.engines = engines;
    }

    @Bean(name = "engine")
    public IEngine engine() {
        final String type = myObject.getType();
        final IEngine engine = engines.get(type);

        return engine;
    }
}
