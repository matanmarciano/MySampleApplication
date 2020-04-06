package com.sample.application.engines;

import org.springframework.stereotype.Component;

@Component("engineTwoType")
public class EngineTwo implements IEngine {
    public String getType() {
        return "EngineTwo";
    }
}
