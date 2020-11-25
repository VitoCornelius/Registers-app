package com.rafal.in4mo.register.domain.exception;

public class RegistryNotFoundException extends Exception {
    public RegistryNotFoundException() {
        super();
    }

    public RegistryNotFoundException(String message) {
        super(message);
    }
}
