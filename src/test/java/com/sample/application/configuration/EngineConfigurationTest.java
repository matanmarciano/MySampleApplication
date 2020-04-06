package com.sample.application.configuration;

import com.sample.application.engines.IEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

@SpringBootTest(classes = EngineConfiguration.class, properties = {
        "someField=someValue",
        "myObject.type=engineOneType",
        "myObject.someOtherField=someOtherValue"
})
class EngineConfigurationTest {
    @MockBean
    @Qualifier("myObject")
    MyObject myObject;

    @MockBean
    private Map<String, IEngine> engines;

    @Test
    void engine() {
        System.out.println("Hi, it is a test here...");
    }
}