package com.rafal.in4mo.register.domain.exception;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super();
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
