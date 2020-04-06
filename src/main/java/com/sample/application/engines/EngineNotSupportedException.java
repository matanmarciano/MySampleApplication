package com.sample.application.engines;

import java.io.IOException;

public class EngineNotSupportedException extends IOException {
    public EngineNotSupportedException(String message) {
        super(message);
    }
}
