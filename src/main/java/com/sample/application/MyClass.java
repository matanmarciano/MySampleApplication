package com.sample.application;

import com.sample.application.engines.EngineFactory;
import com.sample.application.configuration.MyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyClass {
    @Autowired
    MyObject myObject;

    @Autowired
    EngineFactory engineFactory;

    public void print() throws IOException {
        System.out.println("Selected engine is: " + engineFactory.getEngine(myObject.getType()).getType());
    }
}
