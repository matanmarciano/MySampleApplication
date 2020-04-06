package com.sample.application;

import com.sample.application.engines.IEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClass {
    private IEngine engine;

    @Autowired
    public MyClass(@Qualifier(value = "engine") IEngine engine) {
        this.engine = engine;
    }

    public void print() {
        System.out.println("Selected engine is: " + engine.getType());
    }
}
