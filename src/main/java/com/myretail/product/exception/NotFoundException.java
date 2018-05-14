package com.myretail.product.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
