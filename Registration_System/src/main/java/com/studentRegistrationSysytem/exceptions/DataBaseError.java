package com.studentRegistrationSysytem.exceptions;

public class DataBaseError extends RuntimeException {

    public DataBaseError() {
    }
    public DataBaseError(String message) {
        super(message);
    }

}
