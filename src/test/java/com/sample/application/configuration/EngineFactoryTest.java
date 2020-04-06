package com.sample.application.configuration;

import com.sample.application.engines.EngineFactory;
import com.sample.application.engines.EngineNotSupportedException;
import com.sample.application.engines.IEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@SpringBootTest(classes = {EngineFactory.class, IEngine.class}, properties = {
        "someField=someValue",
        "myObject.type=engineOneType",
        "myObject.someOtherField=someOtherValue"
})
class EngineFactoryTest {

    @Autowired
    EngineFactory engineFactory;

    @MockBean
    private Map<String, IEngine> engines;


    @Test
    void invalidEngineType() {
        assertThatExceptionOfType(EngineNotSupportedException.class).isThrownBy(() -> {
            engineFactory.getEngine("engineOneType");
        });
    }
}