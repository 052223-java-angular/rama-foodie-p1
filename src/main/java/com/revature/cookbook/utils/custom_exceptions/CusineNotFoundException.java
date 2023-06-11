package com.revature.cookbook.utils.custom_exceptions;

public class CusineNotFoundException extends RuntimeException {
    public CusineNotFoundException(String message) {
        super(message);
    }
}
