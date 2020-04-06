package com.sample.application.engines;

import org.springframework.stereotype.Component;

@Component("engineOneType")
public class EngineOne implements IEngine {
    public String getType() {
        return "EngineOne";
    }
}
