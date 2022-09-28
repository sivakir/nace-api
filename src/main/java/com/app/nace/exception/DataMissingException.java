package com.app.nace.exception;

public class DataMissingException extends RuntimeException {
    public DataMissingException(){
        super("Required data is missing");
    }
}
