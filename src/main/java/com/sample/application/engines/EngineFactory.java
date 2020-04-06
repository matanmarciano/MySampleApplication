package com.sample.application.engines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class EngineFactory {
    private final Map<String, IEngine> engines;

    @Autowired
    public EngineFactory(Map<String, IEngine> engines) {
        this.engines = engines;
    }

    public IEngine getEngine(String type) throws IOException {
        if(engines.size() == 0) {
            throw new IOException("Engines map is empty");
        }
        final IEngine engine = engines.get(type);
        if(engine == null) {
            throw new EngineNotSupportedException("The engine " + type + " is not supported");
        }
        return engine;
    }
}
