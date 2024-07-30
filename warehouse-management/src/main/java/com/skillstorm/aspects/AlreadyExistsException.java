package com.skillstorm.aspects;

public class AlreadyExistsException extends Exception { 
    public AlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
